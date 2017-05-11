
 drop schema `order_System`;

create schema `order_System`;
use `order_System`;

create table `order_System`.`Book`(
	`book_ISBN` int primary key not null,
    `title` varchar(45),
    `publisher` varchar(45),
    `publication_year` varchar(10),
    `price` double,
    `category` enum('Science', 'Art', 'Religion', 'History', 'Geography'),
	`threshold` int,
    `numberOfBooks` int
);

create table `order_System`.`Authors`(
	`ISBN` int not null,
    `author` varchar(45) not null,
    primary key (ISBN, author)
);

create table `order_System`.`Publisher`(
	`pname` varchar(45)  not null,
    `phone` varchar(10) not null,
    `address` varchar(45),
    primary key (pname, phone)
);

create table `order_System`.`Orders`(
	`order_ID` MEDIUMINT not null auto_increment,
    `book_ISBN` int,
	`quantity` int,
    primary key (order_ID)
);

create table `order_System`.`User`(
	`username` varchar(20) primary key not null,
    `password` varchar(20) not null,
    `firstname` varchar(20),
    `lastname` varchar(20),
    `email` varchar(30),
    `phoneNumber` varchar(10),
    `address` varchar(45),
    `Type` enum('Manager', 'Customer')
);

create table `order_System`.`Sales` (
    sales_id MEDIUMINT not null auto_increment,    
    ISBN int not null,
    username varchar(45) not null,
    price double not null,
    sold_date date not null,
    quantity int not null,
    primary key(sales_id)
);

ALTER TABLE `order_System`.`Sales` ADD CONSTRAINT `fk_Sales_1`
    FOREIGN KEY (`ISBN`)
    REFERENCES `order_System`.`Book` (`book_ISBN`)
    ON DELETE cascade
    ON UPDATE cascade; 

ALTER TABLE `order_System`.`Sales` ADD CONSTRAINT `fk_Sales_2`
    FOREIGN KEY (`username`)
    REFERENCES `order_System`.`User` (`username`)
    ON DELETE cascade
    ON UPDATE cascade;

ALTER TABLE `order_System`.`Authors` ADD CONSTRAINT `fk_Authors_1`
    FOREIGN KEY (`ISBN`)
    REFERENCES `order_System`.`Book` (`book_ISBN`)
    ON DELETE cascade
    ON UPDATE cascade; 

ALTER TABLE `order_System`.`Book` ADD CONSTRAINT `fk_Book_1`
    FOREIGN KEY (`publisher`)
    REFERENCES `order_System`.`Publisher` (`pname`)
    ON DELETE cascade
    ON UPDATE cascade ;
    
ALTER TABLE `order_System`.`Orders` ADD CONSTRAINT `fk_Orders_1`
    FOREIGN KEY (`book_ISBN`)
    REFERENCES `order_System`.`Book` (`book_ISBN`)
    ON DELETE cascade
    ON UPDATE cascade ;
    
-- triggers here
DELIMITER $$
CREATE TRIGGER before_book_update
 BEFORE UPDATE ON order_System.Book
 FOR EACH ROW
BEGIN
	if (NEW.numberOfBooks < 0) then
		signal sqlstate '45000' set message_text = 'My Error Message';
		/* place order or not?*/	
	end if;

END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER after_book_update
 AFTER UPDATE ON order_System.Book
 FOR EACH ROW
BEGIN

	if new.numberOfBooks < new.threshold AND not exists (select * from Orders where book_ISBN = new.book_ISBN) then
		insert into order_System.Orders(book_ISBN,quantity) values(new.book_ISBN, new.threshold);
    end if;
	-- DECLARE q INT;
	-- DECLARE last_id INT;
		
	-- SET q = NEW.numberOfBooks - OLD.numberOfBooks;
	-- if (NEW.numberOfBooks < NEW.threshold) then
		-- if exists (select order_id from order_System.Orders) then
			-- set last_id = (select max(order_id) from order_System.Orders)+1; 
		-- else
			-- set last_id = 0;
		-- end if;
 
		-- INSERT INTO order_System.Orders 
		-- values (last_id, NEW.book_ISBN, q);
-- update if exists?
	-- end if;
END$$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER before_orders_delete
 before DELETE ON order_System.Orders
 FOR EACH ROW
BEGIN
	DECLARE q INT;
		
	SET q = OLD.quantity;
	
	update `order_System`.`Book` 
	set `order_System`.`Book`.numberOfBooks = `order_System`.`Book`.numberOfBooks + q
	where `order_System`.`Book`.book_ISBN = OLD.book_ISBN;

END$$
DELIMITER ;

-- store procdure

delimiter //

create procedure optimize_sold()
begin

delete from order_System.sold
where order_System.Sales.sold_date < DATE_SUB(CURDATE(), INTERVAL 3 MONTH);
end //
delimiter ;

delimiter //
create procedure update_quantities()
begin 

drop table if exists temp;
 
create table temp (
	temp_id int not null auto_increment,
    isbn int not null,
    num int not null,
    primary key(temp_id)
);
 
 
insert into temp (isbn, num)
select `order_System`.`Book`.book_ISBN , `order_System`.`Book`.numberOfBooks - `order_System`.`ShoppingCart`.num_books
from `order_System`.`Book`, `order_System`.`ShoppingCart`
where `order_System`.`Book`.book_ISBN = `order_System`.`ShoppingCart`.ISBN;
 
UPDATE `order_System`.`Book`,temp
SET `order_System`.`Book`.numberOfBooks = temp.num
 
where `order_System`.`Book`.book_ISBN = temp.isbn;
 
drop table temp; 

end //
delimiter ;

delimiter //
create procedure update_sold()
begin

INSERT INTO `order_System`.`Sales` (ISBN, username, price, sold_date, quantity)  
SELECT ISBN,username,price,shopDate,num_books
FROM `order_System`.`ShoppingCart`; 

end //
delimiter ;

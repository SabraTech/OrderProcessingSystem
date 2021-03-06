package Controller;

import View.CustomerUI;
import View.Manager;
import View.SignIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static Model.Engine.LOGGED_USER;
import static Model.Engine.STATEMENT;

/**
 * Created by sabra on 05/05/17.
 */
public class SignInController {
    SignIn view;

    public SignInController(SignIn view) {
        this.view = view;
    }

    public ActionListener getSignInListener() {
        return new SignInListener();
    }

    private void CreateShoppingCart() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE `order_System`.`ShoppingCart` ( ");
        sb.append("item_ID MEDIUMINT not null auto_increment, ");
        sb.append("username varchar(20) not null, ");
        sb.append("ISBN int not null, ");
        sb.append("num_books int, ");
        sb.append("price double, ");
        sb.append("shopDate date, ");
        sb.append("primary key (item_ID));");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("ALTER TABLE `order_System`.`ShoppingCart` ADD CONSTRAINT `shopfk1` ");
        sb1.append("FOREIGN KEY (`username`)");
        sb1.append("REFERENCES `order_System`.`User` (`username`)");
        sb1.append("ON DELETE cascade ON UPDATE cascade;");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ALTER TABLE `order_System`.`ShoppingCart` ADD CONSTRAINT `shopfk2` ");
        sb2.append("FOREIGN KEY (`ISBN`)");
        sb2.append("REFERENCES `order_System`.`Book` (`book_ISBN`)");
        sb2.append("ON DELETE cascade ON UPDATE cascade;");
        try {
            STATEMENT.execute(sb.toString());
            STATEMENT.execute(sb1.toString());
            STATEMENT.execute(sb2.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Can not create shopping cart!");
        }

    }

    public class SignInListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            ResultSet res = null;
            String[] data = view.getSignInData();
            System.out.println(data[0]);
            String sql = "SELECT * FROM User WHERE username = \"" + data[0] + "\" and password = \"" + data[1] + "\"";
            try{
                res = STATEMENT.executeQuery(sql);
                res.next();
                String type = res.getString("Type");
                LOGGED_USER = res.getString("username");
                if(type.equalsIgnoreCase("Manager")){
                    CreateShoppingCart();
                    Manager dialog = new Manager();
                    dialog.pack();
                    view.setVisible(false);
                    view.dispose();
                    dialog.setVisible(true);
                }else{
                    CreateShoppingCart();
                    CustomerUI dialog = new CustomerUI();
                    dialog.pack();
                    view.setVisible(false);
                    view.dispose();
                    dialog.setVisible(true);
                }
            }catch(Exception e1){
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Wrong User Credentials");
            }
        }
    }

}

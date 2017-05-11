package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.ActionsViewsCustomer.AddCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Created by sabra on 06/05/17.
 */
public class AddController {
    AddCustomer view;

    public AddController(AddCustomer view) {
        this.view = view;
    }

    public ActionListener getAddControllerListener() {
        return new AddCustomerListener();
    }

    public class AddCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] data = view.getBookAddedData();
            int isbn = Integer.parseInt(data[0]);
            int cnt = Integer.parseInt(data[1]);
            try {
                ResultSet price = Engine.STATEMENT.executeQuery("SELECT price FROM Book WHERE book_ISBN = " + isbn + ";");
                Double p = 1.0;
                while (price.next()) {
                    p = price.getDouble(1);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("INSERT INTO ShoppingCart (username, ISBN, num_books, price, shopDate) VALUES ( ");
                sb.append("\"" + Engine.LOGGED_USER + "\", ");
                sb.append(isbn + ", ");
                sb.append(cnt + ", ");
                sb.append(cnt * p + ", ");
                sb.append("curdate());");
                Engine.STATEMENT.execute(sb.toString());
                view.dispose();
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in adding new book in cart!");
            }
        }
    }
}

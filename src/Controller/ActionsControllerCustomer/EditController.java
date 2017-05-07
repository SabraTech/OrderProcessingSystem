package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.ActionsViewsCustomer.EditCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by sabra on 06/05/17.
 */
public class EditController {
    EditCustomer view;

    public EditController(EditCustomer view) {
        this.view = view;
    }

    public ActionListener getEditControllerListener() {
        return new EditCustomerListener();
    }

    public class EditCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> data = view.getUpdatedInfo();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE `order_System`.`User` ");
            sb.append("SET password = \"" + data.get(0) + "\", ");
            sb.append("firstname = \"" + data.get(1) + "\", ");
            sb.append("lastname = \"" + data.get(2) + "\", ");
            sb.append("email = \"" + data.get(3) + "\", ");
            sb.append("phoneNumber = \"" + data.get(4) + "\", ");
            sb.append("address = \"" + data.get(5) + "\" ");
            sb.append("WHERE username = \"" + Engine.LOGGED_USER + "\";");
            try {
                Engine.STATEMENT.execute(sb.toString());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in updating the info!");
            }
        }
    }
}

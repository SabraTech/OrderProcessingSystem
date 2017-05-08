package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.ActionsViewsCustomer.CheckOutCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 06/05/17.
 */
public class CheckOutController {
    CheckOutCustomer view;

    public CheckOutController(CheckOutCustomer view) {
        this.view = view;
    }

    public ActionListener getCheckOutControllerListener() {
        return new CheckOutControllerListener();
    }

    public class CheckOutControllerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            sb.append("call update_quantities();");
            try {
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Check out completed successfully!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in check out!");
            }
        }
    }
}

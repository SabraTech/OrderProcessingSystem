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
            try {
                Engine.CONNECTION.setAutoCommit(false);
                StringBuilder sb = new StringBuilder();
                sb.append("call update_quantities();");
                StringBuilder sb1 = new StringBuilder();
                sb1.append("call update_sold()");
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Check out completed successfully!");
                Engine.STATEMENT.execute(sb1.toString());
                JOptionPane.showMessageDialog(null, "Sales added successfully!");
                Engine.CONNECTION.commit();
            } catch (Exception e1) {
                e1.printStackTrace();
                try {
                    Engine.CONNECTION.rollback();
                }catch(Exception e2){

                }
                JOptionPane.showMessageDialog(null, "Error in check out!");
            }
            try {
                Engine.CONNECTION.setAutoCommit(true);
            }catch (Exception e3){

            }
        }
    }
}

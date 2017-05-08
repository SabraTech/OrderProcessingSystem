package Controller.ActionsControllerManager;

import Model.Engine;
import View.ActionsViewsManager.ConfirmOrder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Created by sabra on 08/05/17.
 */
public class ConfirmOrderController {
    ConfirmOrder view;

    public ConfirmOrderController(ConfirmOrder view) {
        this.view = view;
    }

    public ActionListener getConfirmOrderControllerListener() {
        return new ConfirmOrderControllerListener();
    }

    public ResultSet getResultTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `order_System`.`Orders`;");
        ResultSet ans = null;
        try {
            ans = Engine.STATEMENT.executeQuery(sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in view Orders table!");
        }
        return ans;
    }

    public class ConfirmOrderControllerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int itemToDelete = Integer.parseInt(view.getIdtoDelete());
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM `order_System`.`Orders` WHERE order_ID = ");
            sb.append(itemToDelete);
            sb.append(";");
            try {
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Order Confirmed!");
                view.viewTable();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in deleting item from Order!");
            }
        }
    }

}

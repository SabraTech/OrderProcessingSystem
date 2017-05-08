package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.ActionsViewsCustomer.ManageCartCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Created by sabra on 06/05/17.
 */
public class ManageCartController {
    ManageCartCustomer view;

    public ManageCartController(ManageCartCustomer view) {
        this.view = view;
    }

    public ActionListener getManageCartControllerListener() {
        return new ManageCartControllerListener();
    }

    public ResultSet getResultTable() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM `order_System`.`ShoppingCart`;");
        ResultSet ans = null;
        try {
            ans = Engine.STATEMENT.executeQuery(sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in view the shopping cart!");
        }
        return ans;
    }

    public Double getTotalPrice() {
        ResultSet ans = null;
        Double res = 0.0;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT sum(price) FROM `order_System`.`ShoppingCart`;");
        try {
            ans = Engine.STATEMENT.executeQuery(sb.toString());
            res = ans.getDouble(1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in view of total price!");
        }
        return res;
    }

    public class ManageCartControllerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int itemToDelete = Integer.parseInt(view.getIdtoDelete());
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM `order_System`.`ShoppingCart` WHERE item_ID = ");
            sb.append(itemToDelete);
            sb.append(";");
            try {
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Item Deleted!");
                view.fillTheViewTable();
                view.viewTotalPrice();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in deleting item from shopping Cart!");
            }
        }
    }
}

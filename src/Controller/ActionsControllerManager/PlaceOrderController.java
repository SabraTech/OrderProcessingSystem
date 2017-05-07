package Controller.ActionsControllerManager;

import Model.Engine;
import View.ActionsViewsManager.PlaceOrder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 07/05/17.
 */
public class PlaceOrderController {
    PlaceOrder view;

    public PlaceOrderController(PlaceOrder view) {
        this.view = view;
    }

    public ActionListener getPlaceOrderControllerListener() {
        return new PlaceOrderControllerListener();
    }

    public class PlaceOrderControllerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String[] data = view.getOrderData();
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO `order_System`.`Orders` VALUES ( ");
            sb.append(Integer.parseInt(data[0]) + ", ");
            sb.append(Integer.parseInt(data[1]) + ", ");
            sb.append("\"No\");");
            try {
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Order Placed!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "error in placing Order!");
            }
        }
    }
}

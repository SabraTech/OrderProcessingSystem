package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.CustomerUI;
import View.Manager;
import View.StartWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 06/05/17.
 */
public class LogOutController {
    CustomerUI view = null;
    Manager view2 = null;

    public LogOutController(Manager view) {
        this.view2 = view;
    }

    public LogOutController(CustomerUI view) {
        this.view = view;
    }

    public ActionListener getLogOutListener() {
        return new LogOutListener();
    }

    public class LogOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder();
            sb.append("DROP TABLE `order_System`.`ShoppingCart`;");
            try {
                Engine.STATEMENT.execute(sb.toString());
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in close shopping cart");
            }
            StartWindow dialog = new StartWindow();
            if (view != null) {
                dialog.pack();
                view.setVisible(false);
                view.dispose();
                dialog.setVisible(true);
            } else {
                dialog.pack();
                view2.setVisible(false);
                view2.dispose();
                dialog.setVisible(true);
            }
        }
    }
}

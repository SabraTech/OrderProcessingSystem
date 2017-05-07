package Controller.ActionsControllerCustomer;

import View.Customer;
import View.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 06/05/17.
 */
public class LogOutController {
    Customer view;

    public LogOutController(Customer view) {
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
            StartWindow dialog = new StartWindow();
            dialog.pack();
            view.setVisible(false);
            view.dispose();
            dialog.setVisible(true);
        }
    }
}

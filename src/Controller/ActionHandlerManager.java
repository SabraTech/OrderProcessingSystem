package Controller;

import View.ActionsViewsManager.AddManager;
import View.ActionsViewsManager.ConfirmOrder;
import View.ActionsViewsManager.PlaceOrder;
import View.ActionsViewsManager.PromoteUser;
import View.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 07/05/17.
 */
public class ActionHandlerManager {

    public ActionListener getAddBookListener() {
        return new AddBookListener();
    }

    public ActionListener getModifyListener() {
        return new ModifyListener();
    }

    public ActionListener getPlaceOrderListener() {
        return new PlaceOrderListener();
    }

    public ActionListener getConfirmListener() {
        return new ConfirmListener();
    }

    public ActionListener getPromoteListener() {
        return new PromoteListener();
    }

    public ActionListener getViewReportsListener() {
        return new ViewReportsListener();
    }

    public ActionListener getLogOutManagerListener() {
        return new LogOutManagerListener();
    }

    public class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ModifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class PlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlaceOrder dialog = new PlaceOrder();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConfirmOrder dialog = new ConfirmOrder();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class PromoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PromoteUser dialog = new PromoteUser();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ViewReportsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class LogOutManagerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StartWindow dialog = new StartWindow();
            dialog.pack();
            // close the view
            dialog.setVisible(true);
        }
    }
}

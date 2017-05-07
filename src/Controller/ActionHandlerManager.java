package Controller;

import View.ActionsViewsManager.AddManager;
import View.Manager;
import View.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 07/05/17.
 */
public class ActionHandlerManager {
    Manager view;

    public ActionHandlerManager(Manager view) {
        this.view = view;
    }

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
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class PromoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
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
            view.setVisible(false);
            view.dispose();
            dialog.setVisible(true);
        }
    }
}

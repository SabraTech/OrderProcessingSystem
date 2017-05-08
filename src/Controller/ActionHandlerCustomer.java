package Controller;

import View.ActionsViewsCustomer.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 05/05/17.
 */
public class ActionHandlerCustomer {

    public ActionListener getEditListener() {
        return new EditListener();
    }

    public ActionListener getAddListener() {
        return new AddListener();
    }

    public ActionListener getSearchListener() {
        return new SearchListener();
    }

    public ActionListener getManageListener() {
        return new ManageListener();
    }

    public ActionListener getCheckOutListener() {
        return new CheckOutListener();
    }

    public class EditListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            EditCustomer dialog = new EditCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class AddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddCustomer dialog = new AddCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            SearchCustomer dialog = new SearchCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ManageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            ManageCartCustomer dialog = new ManageCartCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class CheckOutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            CheckOutCustomer dialog = new CheckOutCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }
}

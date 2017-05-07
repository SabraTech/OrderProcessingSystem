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

    public ActionListener getlogOutListener() {
        return new LogOutListener();
    }

    private class EditListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            EditCustomer dialog = new EditCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    private class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            AddCustomer dialog = new AddCustomer();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    private class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Search sActionView = new Search();
        }
    }

    private class ManageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            ManageCart mActionView = new ManageCart();
        }
    }

    private class CheckOutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            CheckOut cActionView = new CheckOut();
        }
    }

    private class LogOutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            LogOut lActionView = new LogOut();
        }
    }
}

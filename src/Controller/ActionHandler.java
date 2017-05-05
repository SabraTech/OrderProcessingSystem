package Controller;

import View.ActionsViews.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 05/05/17.
 */
public class ActionHandler {

    private class EditListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Edit eActionView = new Edit();
        }
    }

    private class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Add aActionView = new Add();
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



    public ActionListener getEditListener(){
        return new EditListener();
    }

    public ActionListener getAddListener(){
        return new AddListener();
    }

    public ActionListener getSearchListener(){
        return new SearchListener();
    }

    public ActionListener getManageListener(){
        return new ManageListener();
    }

    public ActionListener getCheckOutListener(){
        return new CheckOutListener();
    }

    public ActionListener getlogOutListener(){
        return new LogOutListener();
    }
}

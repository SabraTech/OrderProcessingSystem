package Controller;

import View.SignIn;
import View.SignUp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Model.Engine.STATEMENT;

/**
 * Created by sabra on 05/05/17.
 */
public class SignUpController {
    SignUp view;

    public SignUpController(SignUp view){
        this.view = view;
    }

    public class SignUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            ResultSet res = null;
            ArrayList<String> data = view.getSignUpData();
            String sql = "INSERT INTO User VALUES ( \"" + data.get(0) + "\", " +
                    "\"" + data.get(1) + "\" , " +
                    "\"" + data.get(2) + "\" , " +
                    "\"" + data.get(3) + "\" , " +
                    "\"" + data.get(4) + "\" , " +
                    "\"" + data.get(5) + "\" , " +
                    "\"" + data.get(6) + "\" , " +
                    "\"" + data.get(7) + "\" ) ";
            try{
                STATEMENT.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Singed Up Successfully!");
                SignIn dialog = new SignIn();
                dialog.pack();
                view.setVisible(false);
                view.dispose();
                dialog.setVisible(true);
            }catch(Exception e1){
                String errorMsg = e1.getMessage();
                JOptionPane.showMessageDialog(null, errorMsg);
            }
        }
    }

    public class SignUpListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            ResultSet res = null;
            ArrayList<String> data = view.getSignUpData();
            String sql = "INSERT INTO User VALUES ( \"" + data.get(0) + "\", " +
                    "\"" + data.get(1) + "\" , " +
                    "\"" + data.get(2) + "\" , " +
                    "\"" + data.get(3) + "\" , " +
                    "\"" + data.get(4) + "\" , " +
                    "\"" + data.get(5) + "\" , " +
                    "\"" + data.get(6) + "\" , " +
                    "\"" + data.get(7) + "\" ) ";
            try{
                STATEMENT.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Singed Up Successfully!");
                SignIn dialog = new SignIn();
                dialog.pack();
                view.setVisible(false);
                view.dispose();
                dialog.setVisible(true);
            }catch(Exception e1){
                String errorMsg = e1.getMessage();
                JOptionPane.showMessageDialog(null, errorMsg);
            }
        }
    }    public ActionListener getSignUpListener() {
        return new SignUpController.SignUpListener();
    }
}

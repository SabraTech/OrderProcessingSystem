package Controller;

import View.Customer;
import View.Manager;
import View.SignIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import static Model.Engine.STATEMENT;

/**
 * Created by sabra on 05/05/17.
 */
public class SignInController {
    SignIn view;

    public SignInController(SignIn view) {
        this.view = view;
    }

    public ActionListener getSignInListener() {
        return new SignInListener();
    }

    public class SignInListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e){
            ResultSet res = null;
            String[] data = view.getSignInData();
            String sql = "SELECT * FROM User WHERE username = \"" + data[0] + "\" and password = \"" + data[1] + "\"";
            try{
                res = STATEMENT.executeQuery(sql);
                res.next();
                String type = res.getString("Type");
                if(type.equalsIgnoreCase("Manager")){
                    new Manager(res);
                    view.setVisible(false);
                    view.dispose();
                }else{
                    new Customer(res);
                    view.setVisible(false);
                    view.dispose();
                }
            }catch(Exception e1){
                JOptionPane.showMessageDialog(null, "Wrong User Credentials");
            }
        }
    }

}

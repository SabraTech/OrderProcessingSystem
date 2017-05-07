package Controller.ActionsControllerManager;

import Model.Engine;
import View.ActionsViewsManager.PromoteUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 07/05/17.
 */
public class PromoteUserController {
    PromoteUser view;

    public PromoteUserController(PromoteUser view) {
        this.view = view;
    }

    public ActionListener getPromoteUserControllerListener() {
        return new PromoteUserControllerListener();
    }

    public class PromoteUserControllerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String user = view.getUsername();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE `order_System`.`User` ");
            sb.append("SET Type = \"Manager\" ");
            sb.append("WHERE username = \"" + user + "\";");
            try {
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Customer " + user + "become Manager!");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error promote user");
            }
        }
    }
}

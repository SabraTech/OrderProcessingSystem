package Controller.ActionsControllerCustomer;

import View.ActionsViewsCustomer.Add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sabra on 06/05/17.
 */
public class AddController {
    Add view;

    public AddController(Add view) {
        this.view = view;
    }

    public class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
}

package View.ActionsViews;

import Controller.ActionsController.AddController;

import java.util.ArrayList;

/**
 * Created by sabra on 06/05/17.
 */
public class Add {
    private AddController addController = new AddController();


    public ArrayList<String> getBookData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(textField1.getText());
        data.add(textField2.getText());
        data.add(textField3.getText());
        data.add(textField4.getText());
        data.add(textField5.getText());
        data.add(textField6.getText());
        data.add(textField7.getText());
        data.add(textField8.getText());
        data.add(textField9.getText());
        return data;
    }

    public String[] getPublisherData() {
        String[] data = new String[3];
        data[0] = textFieldP1.getText();
        data[1] = textFieldP2.getText();
        data[2] = textFieldP3.getText();
        return data;
    }
}

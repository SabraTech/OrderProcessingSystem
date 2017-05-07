package View.ActionsViewsManager;

import Controller.ActionsControllerManager.AddControllerManager;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddManager extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textFieldP2;
    private JTextField textFieldP3;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField11;
    private JTextField textField10;
    private JTextField textFieldP1;
    private JTextField textField3;
    private AddControllerManager addControllerManager;

    public AddManager() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        addControllerManager = new AddControllerManager(this);

        buttonOK.addActionListener(addControllerManager.getAddManagerListener());

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onCancel() {
        dispose();
    }

    public ArrayList<String> getBookData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(textField1.getText());
        data.add(textField2.getText());
        data.add(textField6.getText());
        data.add(textField7.getText());
        data.add(textField8.getText());
        data.add(textField9.getText());
        data.add(textField10.getText());
        data.add(textField11.getText());
        data.add(textField3.getText());
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

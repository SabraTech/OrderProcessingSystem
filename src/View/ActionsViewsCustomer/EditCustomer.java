package View.ActionsViewsCustomer;

import Controller.ActionsControllerCustomer.EditController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EditCustomer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JPasswordField passwordField1;
    private EditController editController;

    public EditCustomer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        editController = new EditController(this);

        buttonOK.addActionListener(editController.getEditControllerListener());

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

    public ArrayList<String> getUpdatedInfo() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(passwordField1.getPassword()));
        data.add(textField2.getText());
        data.add(textField3.getText());
        data.add(textField4.getText());
        data.add(textField5.getText());
        data.add(textField6.getText());
        return data;
    }
}

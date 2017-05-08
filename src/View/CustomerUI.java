package View;

import Controller.ActionHandlerCustomer;
import Controller.ActionsControllerCustomer.LogOutController;
import Model.Engine;

import javax.swing.*;
import java.awt.event.*;

public class CustomerUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton addBookToCartButton;
    private JButton editPersonalInformationButton;
    private JButton searchForBookButton;
    private JButton editShoppingCartButton;
    private JButton checkOutButton;
    private JButton logOutButton;
    private JLabel labelString;
    private ActionHandlerCustomer actionHandlerCustomer;
    private LogOutController logOutController;

    public CustomerUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        actionHandlerCustomer = new ActionHandlerCustomer();
        logOutController = new LogOutController(this);
        addBookToCartButton.addActionListener(actionHandlerCustomer.getAddListener());
        editPersonalInformationButton.addActionListener(actionHandlerCustomer.getEditListener());
        searchForBookButton.addActionListener(actionHandlerCustomer.getSearchListener());
        editShoppingCartButton.addActionListener(actionHandlerCustomer.getManageListener());
        checkOutButton.addActionListener(actionHandlerCustomer.getCheckOutListener());
        logOutButton.addActionListener(logOutController.getLogOutListener());
        labelString.setText("Hi, " + Engine.LOGGED_USER);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

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

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}

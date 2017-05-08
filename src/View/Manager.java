package View;

import Controller.ActionHandlerManager;
import Model.Engine;

import javax.swing.*;
import java.awt.event.*;

public class Manager extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JLabel labelString;
    private ActionHandlerManager handler;

    public Manager() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        handler = new ActionHandlerManager();
        button1.addActionListener(handler.getAddBookListener());
        button2.addActionListener(handler.getModifyListener());
        button3.addActionListener(handler.getPlaceOrderListener());
        button4.addActionListener(handler.getConfirmListener());
        button5.addActionListener(handler.getPromoteListener());
        button6.addActionListener(handler.getViewReportsListener());
        button7.addActionListener(handler.getLogOutManagerListener());
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

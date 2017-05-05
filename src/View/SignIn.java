package View;

import Controller.SignInController;

import javax.swing.*;
import java.awt.event.*;

public class SignIn extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JTextField textField1;
    private JButton signInButton;
    private JPasswordField passwordField1;
    private SignInController signInController;

    public SignIn() {

        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(signInButton);
        signInController = new SignInController(this);
        signInButton.addActionListener(signInController.getSignInListener());

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
        setVisible(false);
        dispose();
    }

    public String[] getSignInData() {
        String[] data = new String[2];
        data[0] = textField1.getText();
        data[1] = String.valueOf(passwordField1.getPassword());
        return data;
    }
}

package View;

import javax.swing.*;
import java.awt.event.*;

public class StartWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonCancel;
    private JButton existingUserButton;
    private JButton newUserButton;

    public StartWindow() {
        setLocationRelativeTo(null);
        setContentPane(contentPane);
        setModal(true);

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

        existingUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignIn dialog = new SignIn();
                dialog.pack();
                setVisible(false);
                dispose();
                dialog.setVisible(true);
            }
        });

        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp dialog = new SignUp();
                dialog.pack();
                setVisible(false);
                dispose();
                dialog.setVisible(true);
            }
        });
    }

    private void onCancel() {
        // add your code here if necessary
        setVisible(false);
        dispose();
    }
}

package View.ActionsViewsManager;

import Controller.ActionsControllerManager.ModifyBookController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ModifyBook extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JButton getButton;
    private JTextField titleField;
    private JTextField publisherField;
    private JTextField yearField;
    private JTextField priceField;
    private JTextField thersholdField;
    private JTextField numField;
    private JTextField categoryField;
    private ModifyBookController modifyBookController;

    public ModifyBook() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        modifyBookController = new ModifyBookController(this);

        getButton.addActionListener(modifyBookController.getDataListener());
        buttonOK.addActionListener(modifyBookController.getModifyBookControllerListener());

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
        // add your code here if necessary
        dispose();
    }

    public String getBookISBN() {
        return textField1.getText();
    }

    public ArrayList<String> getUpdatedData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(titleField.getText());
        data.add(publisherField.getText());
        data.add(yearField.getText());
        data.add(priceField.getText());
        data.add(categoryField.getText());
        data.add(thersholdField.getText());
        data.add(numField.getText());
        return data;
    }

    public void updateFields(ArrayList<String> ans) {
        titleField.setText(ans.get(0));
        publisherField.setText(ans.get(1));
        yearField.setText(ans.get(2));
        priceField.setText(ans.get(3));
        categoryField.setText(ans.get(4));
        thersholdField.setText(ans.get(5));
        numField.setText(ans.get(6));
    }
}

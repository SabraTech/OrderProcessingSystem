package View.ActionsViewsManager;

import Controller.ActionsControllerManager.PlaceOrderController;

import javax.swing.*;
import java.awt.event.*;

public class PlaceOrder extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private PlaceOrderController placeOrderController;

    public PlaceOrder() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        placeOrderController = new PlaceOrderController(this);

        buttonOK.addActionListener(placeOrderController.getPlaceOrderControllerListener());

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

    public String[] getOrderData() {
        String[] data = new String[2];
        data[0] = textField1.getText();
        data[1] = textField2.getText();
        return data;
    }
}

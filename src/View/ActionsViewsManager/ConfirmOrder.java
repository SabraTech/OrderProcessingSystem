package View.ActionsViewsManager;

import Controller.ActionsControllerManager.ConfirmOrderController;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.ArrayList;

import static View.ActionsViewsCustomer.ManageCartCustomer.buildTableModel;

public class ConfirmOrder extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JButton confirmButton;
    private JTable table1;
    private JPanel tablePanel;
    private ConfirmOrderController confirmOrderController;

    public ConfirmOrder() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        confirmOrderController = new ConfirmOrderController(this);
        viewTable();
        confirmButton.addActionListener(confirmOrderController.getConfirmOrderControllerListener());

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
        dispose();
    }

    private void onCancel() {
        dispose();
    }

    public String getIdtoDelete() {
        return textField1.getText();
    }

    public void viewTable() {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        try {
            ResultSet res = confirmOrderController.getResultTable();
            table1.setModel(buildTableModel(res));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in view Results!");
        }
    }
}

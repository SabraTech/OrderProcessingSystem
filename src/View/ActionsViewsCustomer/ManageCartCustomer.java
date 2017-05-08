package View.ActionsViewsCustomer;

import Controller.ActionsControllerCustomer.ManageCartController;

import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

public class ManageCartCustomer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel totalPriceLabel;
    private JTable table1;
    private JTextField textField1;
    private JButton deleteButton;
    private ManageCartController manageCartController;

    public ManageCartCustomer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        manageCartController = new ManageCartController(this);
        fillTheViewTable();
        deleteButton.addActionListener(manageCartController.getManageCartControllerListener());

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

    public void fillTheViewTable() {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        try {
            ResultSet res = manageCartController.getResultTable();
            ResultSetMetaData meta = res.getMetaData();
            int columns = meta.getColumnCount();
            // get column names
            for (int i = 1; i <= columns; i++) {
                columnNames.add(meta.getColumnName(i));
            }
            // get row data
            while (res.next()) {
                ArrayList row = new ArrayList(columns);
                for (int i = 1; i <= columns; i++) {
                    row.add(res.getObject(i));
                }
                data.add(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error in view Results!");
        }
        Vector columnNamesVector = new Vector();
        Vector dataVector = new Vector();
        for (int i = 0; i < data.size(); i++) {
            ArrayList subArray = (ArrayList) data.get(i);
            Vector subVector = new Vector();
            for (int j = 0; j < subArray.size(); j++) {
                subVector.add(subArray.get(j));
            }
            dataVector.add(subVector);
        }
        for (int i = 0; i < columnNames.size(); i++) {
            columnNamesVector.add(columnNames.get(i));
        }
        table1 = new JTable(dataVector, columnNamesVector) {
            public Class getColumnClass(int column) {
                for (int row = 0; row < getRowCount(); row++) {
                    Object o = getValueAt(row, column);
                    if (o != null) {
                        return o.getClass();
                    }
                }
                return Object.class;
            }
        };

    }
}

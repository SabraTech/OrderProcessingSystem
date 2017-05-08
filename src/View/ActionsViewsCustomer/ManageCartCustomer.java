package View.ActionsViewsCustomer;

import Controller.ActionsControllerCustomer.ManageCartController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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
    private JPanel tablePanel;
    private ManageCartController manageCartController;

    public ManageCartCustomer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        manageCartController = new ManageCartController(this);
        viewTotalPrice();
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

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
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

    public void viewTotalPrice() {
        Double total = manageCartController.getTotalPrice();
        totalPriceLabel.setText(String.valueOf(total));
    }

    public void fillTheViewTable() {
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();
        try {
            ResultSet res = manageCartController.getResultTable();
            table1.setModel(buildTableModel(res));
            //tablePanel.add(new JScrollPane(table1), BorderLayout.SOUTH);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in view Results!");
        }
    }
}

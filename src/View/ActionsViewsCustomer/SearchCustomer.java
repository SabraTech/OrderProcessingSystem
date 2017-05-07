package View.ActionsViewsCustomer;

import Controller.ActionsControllerCustomer.SearchController;

import javax.swing.*;
import java.awt.event.*;

public class SearchCustomer extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox comboBox1;
    private JButton searchButton;
    private JTable table1;
    private JTextField textField1;
    private JPanel tablePanel;
    private SearchController searchController;

    public SearchCustomer() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        searchController = new SearchController(this);
        comboBox1.addItem("ISBN");
        comboBox1.addItem("Title");
        comboBox1.addItem("Publisher");
        comboBox1.addItem("Publication Year");
        comboBox1.addItem("Price");
        comboBox1.addItem("Category");

        searchButton.addActionListener(searchController.getSearchControllerListener());

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

    public String getSearchType() {
        return comboBox1.getSelectedItem().toString();
    }

    public String getSearchValue() {
        return textField1.getText();
    }

    public JTable getTable() {
        return table1;
    }

    public JPanel getTablePanel() {
        return tablePanel;
    }
}

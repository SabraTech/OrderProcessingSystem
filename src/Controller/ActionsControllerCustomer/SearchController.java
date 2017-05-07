package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.ActionsViewsCustomer.SearchCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by sabra on 06/05/17.
 */
public class SearchController {
    SearchCustomer view;

    public SearchController(SearchCustomer view) {
        this.view = view;
    }

    public ActionListener getSearchControllerListener() {
        return new SearchCustomerListener();
    }

    public class SearchCustomerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList columnNames = new ArrayList();
            ArrayList data = new ArrayList();
            String type = view.getSearchType();
            String value = view.getSearchValue();
            StringBuilder sb = new StringBuilder();
            switch (type) {
                case "ISBN": {
                    sb.append("SELECT * FROM `order_System`.`Book` WHERE book_ISBN = " + Integer.parseInt(value) + ";");
                    break;
                }
                case "Title": {
                    sb.append("SELECT * FROM `order_System`.`Book` WHERE title = \"" + value + "\";");
                    break;
                }
                case "Publisher": {
                    sb.append("SELECT * FROM `order_System`.`Book` WHERE publisher = \"" + value + "\";");
                    break;
                }
                case "Publication Year": {
                    sb.append("SELECT * FROM `order_System`.`Book` WHERE publication_year = \"" + value + "\";");
                    break;
                }
                case "Price": {
                    sb.append("SELECT * FROM `order_System`.`Book` WHERE price = " + Double.parseDouble(value) + ";");
                    break;
                }
                case "Category": {
                    sb.append("SELECT * FROM `order_System`.`Book` WHERE category = \"" + value + "\";");
                    break;
                }
                default: {

                }
            }
            try {
                ResultSet res = Engine.STATEMENT.executeQuery(sb.toString());
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
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in Search Results!");
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
            JTable table = view.getTable();
            table = new JTable(dataVector, columnNamesVector) {
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
            JPanel panel = view.getTablePanel();
            panel.add(new JScrollPane(table), BorderLayout.SOUTH);
        }
    }
}

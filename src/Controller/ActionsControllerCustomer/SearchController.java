package Controller.ActionsControllerCustomer;

import Model.Engine;
import View.ActionsViewsCustomer.SearchCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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
                view.fillTheTable(res);
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "Error in Search Results!");
            }
        }
    }
}

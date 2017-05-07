package Controller.ActionsControllerManager;

import View.ActionsViewsManager.AddManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import static Model.Engine.STATEMENT;

/**
 * Created by sabra on 07/05/17.
 */
public class AddControllerManager {
    AddManager view;

    public AddControllerManager(AddManager view) {
        this.view = view;
    }

    public ActionListener getAddManagerListener() {
        return new AddControllerManager.AddManagerListener();
    }

    public class AddManagerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ResultSet res = null;
            ArrayList<String> data = view.getBookData();
            String[] pdata = view.getPublisherData();
            StringBuilder sb1 = new StringBuilder();
            sb1.append("INSERT INTO Publisher VALUES (");
            sb1.append("\"" + pdata[0] + "\", ");
            sb1.append("\"" + pdata[1] + "\", ");
            sb1.append("\"" + pdata[2] + "\") ");
            String sqlPublisher = sb1.toString();
            int bookId = Integer.parseInt(data.get(0));
            double price = Double.parseDouble(data.get(4));
            int threshold = Integer.parseInt(data.get(6));
            int numOfBooks = Integer.parseInt(data.get(7));
            String sqlBook = "INSERT INTO User VALUES ( " + bookId + ", " +
                    "\"" + data.get(1) + "\" , " +
                    "\"" + data.get(2) + "\" , " +
                    "\"" + data.get(3) + "\" , " + price + ", " +
                    "\"" + data.get(5) + "\" , " + data.get(6) + ", " + data.get(7) + ") ";
            String[] parts = data.get(8).split(",");
            ArrayList<String> sqlsAuthors = new ArrayList<String>();
            StringBuilder sb = new StringBuilder();
            for (String s : parts) {
                sb.append("INSERT INTO Authors VALUES ( ");
                sb.append(bookId + ", ");
                sb.append("\"");
                sb.append(s);
                sb.append("\")");
                sqlsAuthors.add(sb.toString());
                sb = new StringBuilder();
            }
            try {
                STATEMENT.executeQuery(sqlPublisher);
                STATEMENT.executeQuery(sqlBook);
                for (String s : sqlsAuthors) {
                    STATEMENT.executeQuery(s);
                }
                JOptionPane.showMessageDialog(null, "Book Added to database!");
            } catch (Exception e1) {
                String errorMsg = e1.getMessage();
                JOptionPane.showMessageDialog(null, errorMsg);
            }
        }
    }
}

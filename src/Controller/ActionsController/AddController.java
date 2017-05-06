package Controller.ActionsController;

import View.ActionsViews.Add;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by sabra on 06/05/17.
 */
public class AddController {
    Add view;

    public AddController(Add view) {
        this.view = view;
    }

    public class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ResultSet res = null;
            ArrayList<String> data = view.getBookData();
            String[] pdata = view.getPublisherData();
            String sqlPublisher = "INSERT INTO Publisher VALUES"
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
        }
    }
}

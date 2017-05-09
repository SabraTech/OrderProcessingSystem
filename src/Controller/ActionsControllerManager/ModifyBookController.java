package Controller.ActionsControllerManager;

import Model.Engine;
import View.ActionsViewsManager.ModifyBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by sabra on 08/05/17.
 */
public class ModifyBookController {
    ModifyBook view;

    public ModifyBookController(ModifyBook view) {
        this.view = view;
    }

    public ActionListener getModifyBookControllerListener() {
        return new ModifyBookControllerListener();
    }

    public ActionListener getDataListener() {
        return new DataListener();
    }

    public class ModifyBookControllerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> data = view.getUpdatedData();
            System.out.println(data.get(2));
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE `order_System`.`Book` SET title = \"" + data.get(0) + "\"");
            sb.append(", publisher = \"" + data.get(1) + "\"");
            sb.append(", publication_year = \"" + data.get(2) + "\"");
            sb.append(", price = " + Double.parseDouble(data.get(3)));
            sb.append(", category = \"" + data.get(4) + "\"");
            sb.append(", threshold = " + Integer.parseInt(data.get(5)));
            sb.append(", numberOfBooks = " + Integer.parseInt(data.get(6)));
            sb.append(" WHERE book_ISBN = " + Integer.parseInt(view.getBookISBN()) + ";");
            System.out.println(sb.toString());
            try {
                Engine.STATEMENT.execute(sb.toString());
                JOptionPane.showMessageDialog(null, "Book Updated!");
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in updating the book!");
            }

        }
    }

    public class DataListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int isbn = Integer.parseInt(view.getBookISBN());
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM `order_System`.`Book` WHERE book_ISBN = ");
            sb.append(isbn + ";");
            try {
                ResultSet res = Engine.STATEMENT.executeQuery(sb.toString());
                ArrayList<String> ans = new ArrayList<String>();
                while (res.next()) {
                    ans.add(res.getString("title"));
                    ans.add(res.getString("publisher"));
                    ans.add(res.getString("publication_year"));
                    ans.add(res.getString("price"));
                    ans.add(res.getString("category"));
                    ans.add(res.getString("threshold"));
                    ans.add(res.getString("numberOfBooks"));
                }
                view.updateFields(ans);
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in getting the book row!");
            }
        }
    }

}

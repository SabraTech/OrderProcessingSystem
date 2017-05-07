package View;

import Controller.ActionHandlerManager;
import Model.Engine;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sabra on 05/05/17.
 */
public class Manager extends JFrame {

    JButton addBook, modify, placeOrder, confirm, promote, viewReports, logOut;
    private ActionHandlerManager handler;
    private JLabel activeUser;

    public Manager() {
        super();
        this.setVisible(true);
        Container content = this.getContentPane();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BorderLayout());

        activeUser = new JLabel("Hi, " + Engine.LOGGED_USER);
        handler = new ActionHandlerManager(this);
        addBook = new JButton("Add New Book");
        modify = new JButton("Update Existing Book");
        placeOrder = new JButton("Make new order for books");
        confirm = new JButton("Confirm Order");
        promote = new JButton("Promote Customer to Manager");
        viewReports = new JButton("View Reports");
        logOut = new JButton("Log Out");


        JPanel p = new JPanel();
        p.add(activeUser);
        p.add(addBook);
        p.add(modify);
        p.add(placeOrder);
        p.add(confirm);
        p.add(promote);
        p.add(viewReports);
        p.add(logOut);
        content.add(p, CENTER_ALIGNMENT);

    }
}

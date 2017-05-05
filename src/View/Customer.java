package View;

import Controller.ActionHandler;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

/**
 * Created by sabra on 05/05/17.
 */
public class Customer extends JFrame {

    JButton edit, add, search, manageCart, checkOut, logOut;
    private JToolBar optionsBar;
    private ActionHandler handler;

    public Customer(ResultSet res){
        super("");
        this.setVisible(true);
        Container content = this.getContentPane();
        this.setSize(800,600);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BorderLayout());

        handler = new ActionHandler();
        edit = new JButton("Edit Personal Information");
        add = new JButton("Add Book");
        search = new JButton("Search Book");
        manageCart = new JButton("Edit Shopping Cart");
        checkOut = new JButton("Check Out");
        logOut = new JButton("Log Out");

        edit.addActionListener(handler.getEditListener());
        add.addActionListener(handler.getAddListener());
        search.addActionListener(handler.getSearchListener());
        manageCart.addActionListener(handler.getManageListener());
        checkOut.addActionListener(handler.getCheckOutListener());
        logOut.addActionListener(handler.getlogOutListener());

        JPanel p = new JPanel();
        p.add(edit);
        p.add(add);
        p.add(search);
        p.add(manageCart);
        p.add(checkOut);
        p.add(logOut);
        content.add(p, CENTER_ALIGNMENT);

    }
}
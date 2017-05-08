package Controller;

import Model.Engine;
import View.ActionsViewsManager.AddManager;
import View.ActionsViewsManager.ConfirmOrder;
import View.ActionsViewsManager.PlaceOrder;
import View.ActionsViewsManager.PromoteUser;
import View.StartWindow;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalTextAlignment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

/**
 * Created by sabra on 07/05/17.
 */
public class ActionHandlerManager {

    public ActionListener getAddBookListener() {
        return new AddBookListener();
    }

    public ActionListener getModifyListener() {
        return new ModifyListener();
    }

    public ActionListener getPlaceOrderListener() {
        return new PlaceOrderListener();
    }

    public ActionListener getConfirmListener() {
        return new ConfirmListener();
    }

    public ActionListener getPromoteListener() {
        return new PromoteListener();
    }

    public ActionListener getViewReportsListener() {
        return new ViewReportsListener();
    }

    public ActionListener getLogOutManagerListener() {
        return new LogOutManagerListener();
    }

    public class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ModifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            AddManager dialog = new AddManager();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class PlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlaceOrder dialog = new PlaceOrder();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ConfirmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ConfirmOrder dialog = new ConfirmOrder();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class PromoteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PromoteUser dialog = new PromoteUser();
            dialog.pack();
            dialog.setVisible(true);
        }
    }

    public class ViewReportsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JasperReportBuilder reportA = DynamicReports.report();
            JasperReportBuilder reportB = DynamicReports.report();
            JasperReportBuilder reportC = DynamicReports.report();
            reportA.columns(
                    Columns.column("Book ISBN", "ISBN", DataTypes.stringType()),
                    Columns.column("Total Price", "total", DataTypes.stringType()))
                    .title(
                            Components.text("Total Sales Per Book for Last Month")
                                    .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER))
                    .pageFooter(Components.pageXofY())
                    .setDataSource("Select ISBN, sum(price) as total from `order_System`.`Sales` where `order_System`.`sales`.sold_date > DATE_SUB(NOW(), INTERVAL 1 MONTH) group by ISBN;", Engine.CONNECTION);

            reportB.columns(
                    Columns.column("User Name", "username", DataTypes.stringType()),
                    Columns.column("Total Quantity", "t", DataTypes.stringType()))
                    .title(
                            Components.text("Top 5 Customers in the Last 3 Months")
                                    .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER))
                    .pageFooter(Components.pageXofY())
                    .setDataSource("select username, sum(quantity) as t from `order_System`.`Sales` group by username order by t DESC LIMIT 5;", Engine.CONNECTION);


            reportC.columns(
                    Columns.column("Book ISBN", "ISBN", DataTypes.stringType()),
                    Columns.column("Total Quantity Sold", "t", DataTypes.stringType()))
                    .title(
                            Components.text("Top 10 Selling Books for the Last 3 Month")
                                    .setHorizontalTextAlignment(HorizontalTextAlignment.CENTER))
                    .pageFooter(Components.pageXofY())
                    .setDataSource("select ISBN, sum(quantity) as t from `order_System`.`Sales` group by isbn order by t DESC LIMIT 10;", Engine.CONNECTION);


            try {
                reportA.show();
                reportA.toPdf(new FileOutputStream("/home/sabra/ReportA.pdf"));
                reportB.show();
                reportB.toPdf(new FileOutputStream("/home/sabra/ReportA.pdf"));
                reportC.show();
                reportC.toPdf(new FileOutputStream("/home/sabra/ReportA.pdf"));
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "error in output the reports");
            }
        }
    }

    public class LogOutManagerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StartWindow dialog = new StartWindow();
            dialog.pack();
            // close the view
            dialog.setVisible(true);
        }
    }
}

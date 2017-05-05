package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by sabra on 05/05/17.
 */
public class Engine {

    static final String JDDC_DRIVER = "com.mysql.jdbc.Drive";
    static final String DataBaseURL = "jdbc:mysql://localhost/order_System";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static String LOGGED_USER = null;
    public static Connection CONNECTION = null;
    public static Statement STATEMENT = null;

    public Engine(){
        try{
            System.out.println("Connecting to database...");
            CONNECTION = DriverManager.getConnection(DataBaseURL, USER, PASSWORD);
            STATEMENT = CONNECTION.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}

package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class dbutilities {

    final static String url;
    final static String username;
    final static String password;

    static{

        ResourceBundle rb = ResourceBundle.getBundle("dbdetails");

        url = rb.getString("url");
        username = rb.getString("username");
        password = rb.getString("password");

    }


    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName(url);

        } catch (Exception e) {
            e.printStackTrace();
        }

        String url2 = "jdbc:mysql://localhost:3306/constructweek";

        try {

            con = DriverManager.getConnection(url2,username,password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}


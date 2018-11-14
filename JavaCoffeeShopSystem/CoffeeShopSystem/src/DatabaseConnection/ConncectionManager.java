/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import MainProgram.SubCat;
/**
 *
 * @author Andre Darsono
 */
public class ConncectionManager {

    private static String server = "jdbc:mysql://localhost/coffee_shop";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            connection = LogOn();
        }
        return connection;
    }

    private static Connection LogOn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Conection Success");
            return DriverManager.getConnection(server, username, password);
        } catch (SQLException ex) {
            ex.printStackTrace(System.err);
            System.out.println("Connection Error" + ex.toString());
        } catch (ClassNotFoundException cx) {
            cx.printStackTrace(System.err);
            System.out.println("JDBC.ODBC Driver not found");
        }
        return null;
    }

    private static void LogOff() {
        try {
            connection.close();
            System.out.println("Disconnected");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}

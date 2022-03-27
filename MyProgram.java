import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.DriverManager;

import Lib.Core.Account;
import Lib.Helper.MD5;

public class MyProgram {

    public static final String serverName = "localhost";
    public static final String portNum = "3306";
    public static final String databaseName = "Test";
    public static final String username = "sonloc";
    public static final String password = "phansonloc123";

    public static ArrayList<Account> getUserAccounts() {

        ArrayList<Account> accounts = new ArrayList<Account>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNum + "/" + databaseName,
                    username, password);
            if (conn != null) {
                java.sql.Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM Users;");
                while (rs.next()) {
                    Account acc = new Account();
                    acc.setUsername(rs.getString(2));
                    acc.setPassword(rs.getString(3));
                    accounts.add(acc);
                }

                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }

    public static void studentEnrollToCourse(String studentId, String courseId) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNum + "/" + databaseName,
                    username, password);
            if (conn != null) {
                java.sql.Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT COUNT(Id) FROM Courses WHERE Id = '" + courseId + "'");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        studentEnrollToCourse("1712571", "202250101");
    }
}
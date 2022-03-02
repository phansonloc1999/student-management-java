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

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNum + "/" + databaseName,
                    username, password);
            if (conn != null) {
                java.sql.Statement stm = conn.createStatement();
                stm.execute("truncate Users");
                String encryptedPass = null;
                try {
                    encryptedPass = MD5.encode("phansonloc123");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(encryptedPass);
                stm.execute(
                        "INSERT INTO Users (ID, Username, Password, Name) VALUES (1712571, '1712571', '" + encryptedPass
                                + "', 'Phan Son Loc')");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ArrayList<Account> accounts = getUserAccounts();

        Console console = System.console();
        if (console == null) {
            System.out.println("Coudln't get Console instance!");
        }
        String username = console.readLine("Enter your username: ");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        String password = new String(passwordArray);
        String hashedPassword = null;
        try {
            hashedPassword = MD5.encode(password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Account account : accounts) {
            if (account.authenticate(username, hashedPassword)) {
                System.out.println("Logged in as " + username);
                return;
            }
        }
        System.out.println("Incorrect username or password!");
    }
}
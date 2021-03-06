import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import Lib.Core.Account;
import Lib.Helper.MD5;

public class MyProgram {

    public static final String serverName = "localhost";
    public static final String portNum = "3306";
    public static final String databaseName = "Test";
    public static final String username = "sonloc";
    public static final String password = "phansonloc123";
    private static Connection connection = null;

    public static ArrayList<Account> getUsers() {

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

    public static Connection getDBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNum + "/" + databaseName,
                    username, password);
            if (connection != null) {
                System.out.println("DB Connected!");
                return connection;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void studentEnrollToCourse(String studentId, String courseId) {
        if (connection != null) {
            java.sql.Statement stm = null;
            try {
                stm = connection.createStatement();
                ResultSet rs = null;

                rs = stm.executeQuery("SELECT * FROM Courses");

                while (rs.next()) {
                    System.out.println("Id: " + rs.getInt("Id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Credit: " + rs.getInt("Credit"));
                    System.out.println("Tuition fee: " + rs.getInt("Tuition_Fee"));
                    System.out.println("This is a test string!");
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap username: ");
        String username = scanner.nextLine();
        System.out.print("Nhap password: ");
        Console console = System.console();
        String password = new String(console.readPassword());
        System.out.print("Nhap ho va ten: ");
        String name = scanner.nextLine();
        try {
            String encodedPassword = MD5.encode(password);
            String query = "INSERT INTO Users VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, encodedPassword);
            statement.setString(4, name);
            statement.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getDBConnection();
        addUser();
    }
}
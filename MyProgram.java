import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.DriverManager;

import Lib.Core.Account;
import Lib.Core.Course;
import Lib.Core.Student;

public class MyProgram {

    public static ArrayList<Account> getUserAccounts() {
        // try {
        // Class.forName("com.mysql.jdbc.Driver");
        // } catch (ClassNotFoundException e) {
        // e.printStackTrace();
        // }

        ArrayList<Account> accounts = new ArrayList<Account>();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "sonloc", "");
            if (conn != null) {
                java.sql.Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM Users;");
                while (rs.next()) {
                    System.out.println(
                            rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
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
        // Student student = new Student(1712571, "Phan Son Loc", "1712571",
        // "phansonloc123");
        // Course cs101 = new Course(2022101, "Computer Science 101", 4, 130);
        // Course math50 = new Course(202250, "Linear Algebra 40", 4, 130);
        // student.printInfo();
        // student.enrollCourse(cs101);
        // student.enrollCourse(math50);
        // student.printTuitionFee();
        // System.out.println("Logged in: " + student.login(new Account("1712571",
        // "phansonloc123")));

        // try (PrintWriter out = new PrintWriter("student.txt");) {
        // out.println(student.toString());
        // } catch (IOException i) {
        // i.printStackTrace();
        // }

        // try {
        // File file = new File("student.txt");
        // Scanner scanner = new Scanner(file);
        // Student student = new Student();

        // while (scanner.hasNextLine()) {
        // String[] tokens = scanner.nextLine().split(": ");
        // if (tokens[0].equals("Username"))
        // student.getAccount().setUsername(tokens[1]);
        // if (tokens[0].equals("Password"))
        // student.getAccount().setPassword(tokens[1]);

        ArrayList<Account> accounts = getUserAccounts();

        Console console = System.console();
        if (console == null) {
            System.out.println("Coudln't get Console instance!");
        }
        String username = console.readLine("Enter your username: ");
        char[] passwordArray = console.readPassword("Enter your secret password: ");
        String password = new String(passwordArray);

        for (Account account : accounts) {
            if (account.authenticate(username, password)) {
                System.out.println("Logged in as " + username);
                return;
            }
        }
        System.out.println("Incorrect username or password!");
    }
}
import java.io.*;
import java.util.Scanner;

import Lib.Account;
import Lib.Course;
import Lib.Student;

public class MyProgram {
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

        try {
            File file = new File("student.txt");
            Scanner scanner = new Scanner(file);
            Student student = new Student();

            while (scanner.hasNextLine()) {
                String[] tokens = scanner.nextLine().split(": ");
                if (tokens[0].equals("Username"))
                    student.getAccount().setUsername(tokens[1]);
                if (tokens[0].equals("Password"))
                    student.getAccount().setPassword(tokens[1]);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
import Lib.Course;
import Lib.Student;

public class MyProgram {
    public static void main(String[] args) {
        Student student = new Student(1712571, "Phan Son Loc", "1712571", "phansonloc123");
        Course cs101 = new Course(2022101, "Computer Science 101", 4, 130);
        Course math50 = new Course(202250, "Linear Algebra 40", 4, 130);
        student.printInfo();
        student.enrollCourse(cs101);
        student.enrollCourse(math50);
        student.printTuitionFee();
        System.out.println("Logged in: " + student.login("1712571", "phansonloc123"));
    }
}
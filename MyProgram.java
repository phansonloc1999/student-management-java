import Lib.Course;
import Lib.Student;

public class MyProgram {
    public static void main(String[] args) {
        Student student = new Student(1712571, "Phan Son Loc");
        Course cs101 = new Course(2022101, "Computer Science 101", 4, 130);
        student.printInfo();
        student.enrollCourse(cs101);
        student.printCourses();
        student.unenrollCourse(cs101);
        student.printCourses();
    }
}
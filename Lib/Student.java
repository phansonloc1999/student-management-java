package Lib;

import java.util.ArrayList;

public class Student {
    private int id;
    private String name;

    private ArrayList<Course> courses;

    // Getters va Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Default constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<Course>();
    }

    // Copy constructor
    public Student(Student other) {
        this.id = other.id;
        this.name = other.name;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public void clearInfo() {
        id = -1;
        name = "";
    }

    public void enrollCourse(Course course) {
        courses.add(course);
    }

    public void printCourses() {
        if (courses.size() > 0) {
            System.out.println("List of courses enrolled");
            for (int i = 0; i < courses.size(); i++) {
                courses.get(i).printInfo();
            }
        } else
            System.out.println("No course joined!");
    }

    public void unenrollCourse(Course course) {
        if (courses.size() > 0) {
            for (int i = 0; i < courses.size(); i++) {
                if (courses.get(i).getId() == course.getId()) {
                    courses.remove(i);
                }
            }
        } else
            System.out.println("No course joined!");
    }
}
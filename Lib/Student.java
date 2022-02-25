package Lib;

public class Student {
    private int id;
    private String name;

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
}

package Lib;

public class Course {
    private int id;
    private String name;
    private int credit;
    private int tuition_fee;

    // Getters and Setters
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getTuitionFee() {
        return tuition_fee;
    }

    public void setTuitionFee(int tuition_fee) {
        this.tuition_fee = tuition_fee;
    }

    public Course(int id, String name, int credit, int tuition_fee) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.tuition_fee = tuition_fee;
    }

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Credit: " + credit);
        System.out.println("Tuition fee: " + tuition_fee + "$");
    }
}

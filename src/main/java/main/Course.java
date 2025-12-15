package main;

public class Course {
    private int id;
    private int numStudents;

    public Course(int id, int numStudents) {
        this.id = id;
        this.numStudents = numStudents;
    }

    public Course(String instructions) {
        String[] parts = instructions.split(" ");

        this.id = Integer.parseInt(parts[0]);
        this.numStudents = Integer.parseInt(parts[1]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public String toString() {
        return "Course{id=" + id + ", numStudents=" + numStudents + "}";
    }
}

package main;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private List<Integer> courses;

    public Teacher(int id, List<Integer> courses) {
        this.id = id;
        this.courses = courses;
    }

    public Teacher(String instructions) {
        String[] lines = instructions.split(" ");

        this.id = Integer.parseInt(lines[0]);
        this.courses = new ArrayList<>();

        for (int i = 1; i < lines.length; i++) {
            int courseId = Integer.parseInt(lines[i]);
            this.courses.add(courseId);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getCourses() {
        return courses;
    }

    public void setCourses(List<Integer> courses) {
        this.courses = courses;
    }

    public boolean canTeachCourse(int courseId) {
        return courses.contains(courseId);
    }

    public String toString() {
        return "Teacher{id=" + id + ", courses=" + courses + "}";
    }
}

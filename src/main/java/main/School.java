package main;

import java.util.List;

public class School {
    private int total;

    private List<Room> rooms;
    private List<Course> courses;
    private List<Teacher> teachers;

    public School(int total, List<Room> rooms, List<Course> courses, List<Teacher> teachers) {
        this.total = total;
        setRooms(rooms);
        setCourses(courses);
        setTeachers(teachers);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        if (rooms.size() != total) {
            throw new IllegalArgumentException("El número de aulas no coincide con el total especificado.");
        }

        this.rooms = rooms;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        if (courses.size() != total) {
            throw new IllegalArgumentException("El número de cursos no coincide con el total especificado.");
        }

        this.courses = courses;
    }

    public List<Teacher> getTeachers() {
        if (teachers.size() != total) {
            throw new IllegalArgumentException("El número de profesores no coincide con el total especificado.");
        }

        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String toString() {
        String result = "School{\n";
        result += "  total=" + total + ",\n";
        result += "  rooms=" + rooms + ",\n";
        result += "  courses=" + courses + ",\n";
        result += "  teachers=" + teachers + "\n";
        result += "}";

        return result;
    }
}

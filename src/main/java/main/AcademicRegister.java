package main;

public class AcademicRegister {
    private Room room;
    private Course course;
    private Teacher teacher;

    public int indexCourse;
    public int indexRoom;
    public int indexTeacher;

    public AcademicRegister(Room room, Course course, Teacher teacher) {
        this.room = room;
        this.course = course;
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isValid() {
        return teacher.canTeachCourse(course.getId()) && room.canHoldStudents(course.getNumStudents());
    }

    public String toString() {
        return "AcademicRegister{course=" + course + ", room=" + room + ", teacher=" + teacher + "}";
    }
}

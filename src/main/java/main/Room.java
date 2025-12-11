package main;

public class Room {
    private int id;
    private int capacity;

    public Room(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public Room(String instructions) {
        String[] lines = instructions.split(" ");

        this.id = Integer.parseInt(lines[0]);
        this.capacity = Integer.parseInt(lines[1]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean canHoldStudents(int numStudents) {
        return this.capacity >= numStudents;
    }

    public String toString() {
        return "Room{id=" + id + ", capacity=" + capacity + "}";
    }
}

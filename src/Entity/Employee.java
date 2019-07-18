package Entity;

import Issue.PhoneIssue;

public abstract class Employee {
    private String name;
    private int id;
    private int level;
    private boolean free;

    public Employee(String name, int id, int level) {
        this.name = name;
        this.id = id;
        this.level = level;
        this.free = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public abstract boolean process(PhoneIssue issue);
}

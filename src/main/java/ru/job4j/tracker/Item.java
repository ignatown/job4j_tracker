package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
        id = -1;
        name = "default";
    }

    public Item(int id) {
        this.id = -1;
        name = "default";
    }

    public Item(int id, String name) {
        this.id = -1;
        this.name = name;
    }

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
}
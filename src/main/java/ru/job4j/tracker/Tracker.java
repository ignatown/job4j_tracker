package ru.job4j.tracker;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(Item[] item){
        Item[] rls = new Item[size];
        for (int i = 0; i < size; i++)
            rls[i] = item[i];
        return rls;
    }

    public Item findByName(String name){
        Item rls = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(name)) {
                rls = items[i];
            }
        }
        return rls;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
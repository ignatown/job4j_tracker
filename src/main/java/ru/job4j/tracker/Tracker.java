package ru.job4j.tracker;

import java.util.Arrays;

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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String name){
        Item[] rls = new Item[100];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(name)) {
                rls[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(rls, size);
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
package ru.job4j.tracker;

import java.util.ArrayList;

public class Tracker {

    private ArrayList<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void add(Item item) {
        item.setId(ids++);
        items.add(item);

    }

    public ArrayList<Item> findAll() {
        return items;
    }

    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> rls = new ArrayList<Item>();
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items.get(i).equals(name)) {
                rls.add(items.get(i));
                size++;
            }
        }
        return rls;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item newItem) {
            int i = indexOf(id);
            if (i != -1) {
                items.set(i, newItem);
                newItem.setId(id);
                return true;
            } else {
                return false;
            }
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items.get(index);
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
       if (i != -1) {
            items.remove(i);
            return true;
       } else {
           return false;
       }
    }
}
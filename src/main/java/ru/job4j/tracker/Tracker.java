package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item[] getItems() {
        return items;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll(){
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String name){
        Item[] rls = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i].equals(name)) {
                rls[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(rls, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item newItem){
            int i = indexOf(id);
            if (i != -1) {
                items[i] = newItem;
                newItem.setId(id);
                return true;
            }
            else return false;
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

    public boolean delete(int id) {
        int i = indexOf(id);
       if (i != -1) {
            items[i] = null;
            System.arraycopy(items, i+1, items, i, size-i);
            items[size - 1] = null;
            size--;
            return true;
                     }
       else return false;
    }


}
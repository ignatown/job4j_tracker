package ru.job4j.tracker;

import java.util.Comparator;

public class SortByDescending implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        return i1.getId() - i2.getId();
    }
}

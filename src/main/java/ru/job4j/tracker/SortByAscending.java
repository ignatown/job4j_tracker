package ru.job4j.tracker;

import java.util.Comparator;

public class SortByAscending implements Comparator<Item> {
    @Override
    public int compare(Item i1, Item i2) {
        return i2.getId() - i1.getId();
    }
}
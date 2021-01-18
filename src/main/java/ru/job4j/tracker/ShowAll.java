package ru.job4j.tracker;

import java.util.ArrayList;

public class ShowAll implements UserAction {
    private final Output out;

    public ShowAll(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> newItem = tracker.findAll();
        for (int i = 0; i < newItem.size(); i++) {
            out.println(newItem.get(i));
        }
        return true;
    }
}

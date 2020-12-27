package ru.job4j.tracker;

public class ShowAll implements UserAction{
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] newItem = tracker.findAll();
        for (int i = 0; i < newItem.length; i++) {
            System.out.println(newItem[i]);
        }
        return true;
    }
}

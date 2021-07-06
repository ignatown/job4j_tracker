package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public boolean execute(Input input, Store memTracker) throws SQLException {
        List<Item> newItem = memTracker.findAll();
        for (int i = 0; i < newItem.size(); i++) {
            out.println(newItem.get(i));
        }
        return true;
    }
}

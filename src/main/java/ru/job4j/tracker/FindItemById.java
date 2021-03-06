package ru.job4j.tracker;

import java.sql.SQLException;

public class FindItemById implements UserAction {
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        int id = Integer.valueOf(input.askStr("ID to found: "));
        Item findItem = new Item();
        findItem = memTracker.findById(id);
        if (findItem != null) {
            out.println(findItem);
        } else {
            out.println("Не найдено элемента с таким ID.");
        }
        return true;
    }
}

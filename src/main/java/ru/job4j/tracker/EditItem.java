package ru.job4j.tracker;

import java.sql.SQLException;

public class EditItem implements UserAction {
    private final Output out;

    public EditItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        int id = input.askInt("ID to replace: ");
        String name = input.askStr("New name: ");
        Item replItem = new Item(name);
        if (memTracker.replace(id, replItem)) {
            out.println("Операция проведена успешно.");
        } else {
            out.println("Произошла ошибка");
        }
        return true;
    }
}

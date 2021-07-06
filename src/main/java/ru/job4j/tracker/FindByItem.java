package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FindByItem implements UserAction {
    private final Output out;

    public FindByItem(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        String findName = input.askStr("Name to find: ");
        List<Item> findNames = memTracker.findByName(findName);
        if (findNames.size() > 0) {
            for (int i = 0; i < findNames.size(); i++) {
                out.println(findNames.get(i));
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

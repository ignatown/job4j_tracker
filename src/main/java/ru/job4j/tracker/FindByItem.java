package ru.job4j.tracker;

import java.util.ArrayList;

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
    public boolean execute(Input input, Tracker tracker) {
        String findName = input.askStr("Name to find: ");
        ArrayList<Item> findNames = tracker.findByName(findName);
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

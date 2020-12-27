package ru.job4j.tracker;

public class FindItemById implements UserAction{
    private final Output out;

    public FindItemById(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("ID to found: "));
        Item findItem = new Item();
        findItem = tracker.findById(id);
        if (findItem != null) {
            findItem.toString();
        }
        else {
            out.println("Не найдено элемента с таким ID.");
        }
        return true;
    }
}

package ru.job4j.tracker;

public class EditItem implements UserAction{
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("ID to replace: ");
        String name = input.askStr("New name: ");
        Item replItem = new Item(name);
        if (tracker.replace(id, replItem)) {
            System.out.println("Операция проведена успешно.");
        } else {
            System.out.println("Произошла ошибка");
        }
        return true;
    }
}

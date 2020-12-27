package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("ID to delete: "));
        if (tracker.delete(id)) {
            System.out.println("Операция проведена успешно.");
        } else {
            System.out.println("Произошла ошибка");
        }
        return true;
    }
}

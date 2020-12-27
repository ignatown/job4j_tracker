package ru.job4j.tracker;

public class DeleteItem implements UserAction{
    private final Output out;

    public DeleteItem(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("ID to delete: "));
        if (tracker.delete(id)) {
            out.println("Операция проведена успешно.");
        } else {
            out.println("Произошла ошибка");
        }
        return true;
    }
}

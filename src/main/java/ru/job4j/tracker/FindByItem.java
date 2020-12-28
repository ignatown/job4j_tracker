package ru.job4j.tracker;

public class FindByItem implements UserAction{
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
        Item[] findNames = tracker.findByName(findName);
        if (findNames.length > 0) {
            for (int i = 0; i < findNames.length; i++) {
                out.println(findNames[i]);
            }
        }
        else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

package ru.job4j.tracker;

public class FindByItem implements UserAction{
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String findName = input.askStr("Name to find: ");
        Item[] findNames = new Item[100];
        findNames = tracker.findByName(findName);
        if (findNames.length > 0) {
            for (int i = 0; i < findNames.length; i++) {
                System.out.println(findNames[i]);
            }
        }
        else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

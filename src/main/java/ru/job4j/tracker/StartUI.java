package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] newItem = tracker.findAll();
        for (int i = 0; i < newItem.length; i++) {
            System.out.println(newItem[i]);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        int id = input.askInt("ID to replace: ");
        String name = input.askStr("New name: ");
        Item replItem = new Item(name);
        if (tracker.replace(id, replItem)) {
            System.out.println("Операция проведена успешно.");
        } else {
            System.out.println("Произошла ошибка");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        int id = Integer.valueOf(input.askStr("ID to delete: "));
        if (tracker.delete(id)) {
            System.out.println("Операция проведена успешно.");
        } else {
            System.out.println("Произошла ошибка");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        int id = Integer.valueOf(input.askStr("ID to found: "));
        Item findItem = new Item();
        findItem = tracker.findById(id);
        if (findItem != null) {
            findItem.toString();
        }
        else {
            System.out.println("Не найдено элемента с таким ID.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== 5. Find items by name ====");
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
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
            case 1:
                showAll(input, tracker);
                break;
            case 2:
                editItem(input, tracker);
                break;
            case 3:
                deleteItem(input, tracker);
                break;
            case 4:
                findItemById(input, tracker);
                break;
            case 5:
                findItemByName(input, tracker);
                break;
            case 6:
                run = false;
                break;
                }
            }
        }


    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            switch (select) {
                case 0:
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    tracker.add(item);
            case 1:
             System.out.println("=== Show all items ====");
                Item[] newItem = tracker.findAll();
                for (int i = 0; i < newItem.length; i++)
                    System.out.println(newItem[i]);
                    break;
            case 2:
                System.out.println("=== Edit item ====");
                System.out.print("ID to replace: ");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("New name: ");
                name = scanner.nextLine();
                Item replItem = new Item(name);
                if (tracker.replace(id, replItem)) {
                    System.out.println("Операция проведена успешно.");
                } else {
                    System.out.println("Произошла ошибка");
                }
                break;
            case 3:
                System.out.println("=== Delete item ====");
                System.out.print("ID to delete: ");
                id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Операция проведена успешно.");
                } else {
                    System.out.println("Произошла ошибка");
                }
                break;
            case 4:
                System.out.println("=== Find item by Id ====");
                System.out.print("ID to found: ");
                id = Integer.valueOf(scanner.nextLine());
                Item findItem = new Item();
                findItem = tracker.findById(id);
                if (findItem != null)
                    findItem.toString();
                else
                    System.out.println("Не найдено элемента с таким ID.");
                break;
            case 5:
                System.out.println("=== 5. Find items by name ====");
                System.out.print("Name to find: ");
                String findName = scanner.nextLine();
                Item[] findNames = new Item[100];
                findNames = tracker.findByName(findName);
                if (findNames.length > 0) {
                    for (int i = 0; i < findNames.length; i++) {
                        System.out.println(findNames[i]);
                    }
                }
                else System.out.println("Заявки с таким именем не найдены");
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
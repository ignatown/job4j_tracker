package ru.job4j.oop;

public class fix {
    private String desc;

    public fix(String text) {
        desc = text;
    }

    public static void main(String[] args) {
        String issue = "Fixed.";
        fix item = new fix(issue);
    }
}

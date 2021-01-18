package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void show() {
        System.out.println(this.food);
    }

    public void giveName(String nick) {
        this.name = nick;
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.eat("kotleta");
        gav.giveName("Gav");
        System.out.println("There are " + gav.name + "'s food:");
        gav.show();
        Cat black = new Cat();
        black.eat("fish");
        black.giveName("Black");
        System.out.println("There are " + black.name + "'s food:");
        black.show();
    }
}
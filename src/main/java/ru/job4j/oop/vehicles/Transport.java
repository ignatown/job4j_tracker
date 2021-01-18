package ru.job4j.oop.vehicles;

public class Transport {
    public static void main(String[] args) {
        Vehicle pl1 = new Plane();
        Vehicle pl2 = new Plane();
        Vehicle trn = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = new Vehicle[]{pl1, pl2, trn, bus};

        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}

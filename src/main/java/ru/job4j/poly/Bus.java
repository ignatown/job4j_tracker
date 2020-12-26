package ru.job4j.poly;

public class Bus implements Transport{
    private int numberOfPeople;
    private double rublesPerLiter = 44.5;
    private boolean run;

    @Override
    public void drive() {
    this.run = true;
    }

    @Override
    public void passengers(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
    }

    @Override
    public double fillUp(int liters) {
        return liters*rublesPerLiter;
    }
}

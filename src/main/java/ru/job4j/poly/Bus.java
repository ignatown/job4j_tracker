package ru.job4j.poly;

public class Bus implements Transport{
    private int numberOfPeople;
    private double rublesPerLiter = 44.5;

    @Override
    public void drive() {

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

package ru.job4j.oop.professions;

public class Surgeon extends Doctor {
    private boolean canWorkWithVessels;
    private String specification;

    public void dissect(Client client) {}
    public void sewUp(Client client) {}

    public boolean getVessels() {
        return canWorkWithVessels;
    }

    public String getSpecification() {
        return specification;
    }
}
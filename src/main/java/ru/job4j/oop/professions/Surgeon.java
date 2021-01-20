package ru.job4j.oop.professions;

public class Surgeon extends Doctor {
    private boolean canWorkWithVessels;

    public Surgeon(String name, String surname, String education, int experience,
                   boolean certification, boolean canWorkWithVessels) {
        super(name, surname, education,  experience, certification);
        this.canWorkWithVessels = canWorkWithVessels;

    }

    public void dissect(Client client) {
    }

    public void sewUp(Client client) {
    }

    public boolean getVessels() {
        return canWorkWithVessels;
    }

}
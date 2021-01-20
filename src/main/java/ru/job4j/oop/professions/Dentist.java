package ru.job4j.oop.professions;

public class Dentist extends Doctor {
   private boolean canWorkWithChildren;
   private int priceForVeneers;

    public Dentist(String name, String surname, String education,  int experience,
                                 boolean certification, int priceForVeneers) {
        super(name, surname, education, experience, certification);

        this.priceForVeneers = priceForVeneers;
    }

    public void removeTheTooth(Client client) {
    }

    public void installationOfVeneers(Client client) {

    }

    public void introducePainkillers(Client client) {

    }

    public boolean getCanWorkWithChildren() {
        return canWorkWithChildren;
    }

    public int getPriceForVeneers() {
        return priceForVeneers;
    }
}

package ru.job4j.oop.professions;

public class Dentist extends Doctor{
   private boolean canWorkWithChildren;
   private int priceForVeneers;

    public void removeTheTooth(Client client) {}
    public void installationOfVeneers(Client client) {}
    public void introducePainkillers(Client client) {}

    public boolean getCanWorkWithChildren() {
        return canWorkWithChildren;
    }
    public int GetPriceForVeneers() {
        return priceForVeneers;
    }
}

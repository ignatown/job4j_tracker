package ru.job4j.oop.professions;

public class Surgeon extends Doctor {
    private boolean canWorkWithVessels;
    private String specification;

    public Surgeon(String name, String surname, String education, String brtihday, int experience,
                   boolean certification, boolean canWorkWithVessels,String specification) {
        super(name,surname,education,brtihday,experience,certification);
        this.canWorkWithVessels = canWorkWithVessels;
        this.specification = specification;
    }

    public void dissect(Client client) {}
    public void sewUp(Client client) {}

    public boolean getVessels() {
        return canWorkWithVessels;
    }

    public String getSpecification() {
        return specification;
    }
}
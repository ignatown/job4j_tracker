package ru.job4j.oop.professions;

public class Doctor extends Profession{
  private  int experience;
  private  boolean certification;

    public void diagnosis(Client client) { }
    public void heal(Client client) { }

    public int getExperience() {
        return experience;
    }

    public boolean getCertification() {
        return certification;
    }

}

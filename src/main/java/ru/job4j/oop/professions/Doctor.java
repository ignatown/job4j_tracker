package ru.job4j.oop.professions;

public class Doctor extends Profession {
  private  int experience;
  private  boolean certification;

    public Doctor(String name, String surname, String education,
                  int experience, boolean certification) {
        this.experience = 0;
        this.certification = false;
    }

  public Doctor(String name, String surname, String education, String brtihday,
                int experience, boolean certification) {
    super(name, surname, education, brtihday);
    this.experience = experience;
    this.certification = certification;
  }

    public void diagnosis(Client client) { }

    public void heal(Client client) { }

    public int getExperience() {
        return experience;
    }

    public boolean getCertification() {
        return certification;
    }

}

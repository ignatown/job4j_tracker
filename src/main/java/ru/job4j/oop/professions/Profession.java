package ru.job4j.oop.professions;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String brtihday;

    public Profession(String name, String surname, String education) {
        this.name = "default name";
        this.surname = "default surname";
        this.education = "default education";
        this.brtihday = "default brtihday";
    }

    public Profession(String name, String surname, String education, String brtihday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.brtihday = brtihday;
    }

   public String getName() {
       return name;
   }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBrithday() {
        return brtihday;
    }
}

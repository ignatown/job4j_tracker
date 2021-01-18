package ru.job4j.oop.professions;

public class Programmer extends Engineer {
    private int commercialExperience;
    private boolean knowledgeOfEnglish;
    private String programmingLanguage;

    public Programmer(String name, String surname, String education, String brtihday,
                      boolean practitioner, boolean electricalSafety, int commercialExperience,
                            boolean knowledgeOfEnglish, String programmingLanguage) {
        super(name, surname, education, brtihday, practitioner, electricalSafety);
        this.commercialExperience = commercialExperience;
        this.knowledgeOfEnglish = knowledgeOfEnglish;
        this.programmingLanguage = programmingLanguage;
    }

    public void writeCode(Client client) {};
    public void testCode(Client client) {};
    public void refactorCode(Client client) {};

    public int getCommercialExperience() {
        return commercialExperience;
    }

    public boolean getKnowledgeOfEnglish() {
        return knowledgeOfEnglish;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}

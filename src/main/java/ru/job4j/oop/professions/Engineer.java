package ru.job4j.oop.professions;

public class Engineer extends Profession {
    private boolean practitioner;
    private boolean electricalSafety;

    public Engineer() {
        practitioner = false;
        electricalSafety = false;
    }

    public Engineer(String name, String surname, String education, String brtihday,
                    boolean practitioner, boolean electricalSafety) {
        super(name, surname, education, brtihday);
            this.practitioner = practitioner;
            this.electricalSafety = electricalSafety;
    }

    public void preparationOfTechnicalSpecifications(Client client) {};
    public void solutionPresentation(Client client) {};

    public boolean getPractitioner() {
        return practitioner;
    }
    public boolean getElectricalSafety() {
        return electricalSafety;
    }
}

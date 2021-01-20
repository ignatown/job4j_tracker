package ru.job4j.oop.professions;

public class Engineer extends Profession {
    private boolean practitioner;
    private boolean electricalSafety;

    public Engineer(String name, String surname, String education,
                    boolean practitioner, boolean electricalSafety) {
        this.practitioner = false;
        this.electricalSafety = false;
    }

    public Engineer(String name, String surname, String education,
                    boolean practitioner) {
        super(name, surname, education, brtihday);
            this.practitioner = practitioner;
            this.electricalSafety = electricalSafety;
    }

    public void preparationOfTechnicalSpecifications(Client client) {
    }

    public void solutionPresentation(Client client) {
    }

    public boolean getPractitioner() {
        return practitioner;
    }

    public boolean getElectricalSafety() {
        return electricalSafety;
    }
}

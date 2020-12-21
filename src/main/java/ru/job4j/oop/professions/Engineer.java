package ru.job4j.oop.professions;

public class Engineer extends Profession{
    private boolean practitioner;
    private boolean electricalSafety;

    public void preparationOfTechnicalSpecifications(Client client) {};
    public void solutionPresentation(Client client) {};

    public boolean getPractitioner() {
        return practitioner;
    }
    public boolean getElectricalSafety() {
        return electricalSafety;
    }
}

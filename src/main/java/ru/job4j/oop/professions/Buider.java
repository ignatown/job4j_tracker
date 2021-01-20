package ru.job4j.oop.professions;

public class Buider extends Engineer {
    private boolean canWorkAtHeight;
    private boolean guestWorker;
    private String buildingSpecification;

    public Buider(String name, String surname, String education,
                      boolean practitioner, boolean electricalSafety,
                  boolean canWorkAtHeight, String buildingSpecification) {
        super(name, surname, education, practitioner, electricalSafety);
        this.canWorkAtHeight = canWorkAtHeight;
        this.buildingSpecification = buildingSpecification;
    }

    public void layBricks(Client client) {
    }

    public void dismantling(Client client) {
    }

    public boolean getCanWorkAtHeight() {
        return canWorkAtHeight;
    }

    public String getBuildingSpecification() {
        return buildingSpecification;
    }
}

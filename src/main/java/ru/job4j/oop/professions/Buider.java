package ru.job4j.oop.professions;

public class Buider extends Engineer{
    private boolean canWorkAtHeight;
    private boolean guestWorker;
    private String buildingSpecification;

    public Buider(String name, String surname, String education, String brtihday,
                      boolean practitioner, boolean electricalSafety, boolean canWorkAtHeight,
                                 boolean guestWorker, String buildingSpecification) {
        super(name, surname, education, brtihday, practitioner, electricalSafety);
        this.canWorkAtHeight = canWorkAtHeight;
        this.guestWorker = guestWorker;
        this.buildingSpecification = buildingSpecification;
    }


    public void layBricks(Client client) {};
    public void dismantling(Client client) {};

    public boolean getCanWorkAtHeight() {
        return canWorkAtHeight;
    }
    public boolean getGuestWorker() {
        return guestWorker;
    }
    public String getBuildingSpecification() {
        return buildingSpecification;
    }

}

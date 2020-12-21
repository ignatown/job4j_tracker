package ru.job4j.oop.professions;

public class Buider extends Engineer{
    private boolean canWorkAtHeight;
    private boolean guestWorker;
    private String buildingSpecification;

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

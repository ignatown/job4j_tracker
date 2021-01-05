package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class EagerLoadingTrackerSingle {
    private static final EagerLoadingTrackerSingle INSTANCE = new EagerLoadingTrackerSingle();

    private EagerLoadingTrackerSingle() {
    }

    public static EagerLoadingTrackerSingle getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        EagerLoadingTrackerSingle tracker = EagerLoadingTrackerSingle.getInstance();
    }

}
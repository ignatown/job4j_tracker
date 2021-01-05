package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class LazyLoadingTrackerSingle {
    private static LazyLoadingTrackerSingle instance;

    private LazyLoadingTrackerSingle() {
    }

    public static LazyLoadingTrackerSingle getInstance() {
        if (instance == null) {
            instance = new LazyLoadingTrackerSingle();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }

}
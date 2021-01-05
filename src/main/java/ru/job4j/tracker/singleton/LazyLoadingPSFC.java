package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class LazyLoadingPSFC {
    private LazyLoadingPSFC() {
    }

    public static LazyLoadingPSFC getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final LazyLoadingPSFC INSTANCE = new LazyLoadingPSFC();
    }

    public static void main(String[] args) {
        LazyLoadingPSFC tracker = LazyLoadingPSFC.getInstance();
    }

}
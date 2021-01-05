package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public enum EnumTrackerSingle {
    INSTANCE; /* здесь мы указываем перечисления. */

    /* Конструкторы и методы. */
    public Item add(Item model) {
        return model;
    }
}
package ru.job4j.tracker;

import java.sql.SQLException;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit..";
    }

    @Override
    public boolean execute(Input input, Store memTracker) throws SQLException {
        return false;
    }
}

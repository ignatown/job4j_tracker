package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;
import java.util.Collections;
import java.util.Comparator;

public class TrackerTest {
    @Test
    public void whenIncrease() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("A"));
        tracker.add(new Item("C"));
        tracker.add(new Item("D"));
        tracker.add(new Item("B"));
        Comparator<Item> comparator = new SortByAscending();
        tracker.findAll().sort(comparator);
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
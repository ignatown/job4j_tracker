package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.Comparator;

public class MemTrackerTest {
    @Test
    public void whenIncrease() {
        MemTracker memTracker = new MemTracker();
        memTracker.add(new Item("A"));
        memTracker.add(new Item("C"));
        memTracker.add(new Item("D"));
        memTracker.add(new Item("B"));
        Comparator<Item> comparator = new SortByAscending();
        memTracker.findAll().sort(comparator);
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        memTracker.add(bug);
        int id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}
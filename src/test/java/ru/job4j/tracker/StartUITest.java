package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New item"));
        Output out = new StubOutput();
        String replacedName = "Replaced item";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()) ,"Replaced item","1"}
        );
        UserAction[] actions = {
                new EditItem(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0",String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteItem(out),
                new Exit()
        };
    }

    @Test
    public void whenShowAll() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "A", "0", "B","0","A","1", "2"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAll(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByName("A").length, is(2));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        String findName = "Find Me";
        Input in = new StubInput(
                new String[] {"0", findName, "0",findName,"0",findName,"0","AAA","1",findName,"2"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new FindByItem(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findByName(findName).length, is(3));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Output out = new StubOutput();
        String findName = "B";
        Input in = new StubInput(
                new String[] {"0", "A","0","B","1","2","2"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new FindItemById(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(2).getName(), is(findName));
    }
}

package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;

public class StartUI {
    private final Output out;
    private ArrayList<UserAction> actions = new ArrayList<UserAction>();

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store memTracker, ArrayList<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, memTracker);
        }
    }

    private void showMenu(ArrayList<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws SQLException {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        MemTracker memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new CreateAction(output));
        actions.add(new FindByItem(output));
        actions.add(new FindItemById(output));
        actions.add(new DeleteItem(output));
        actions.add(new ShowAll(output));
        actions.add(new EditItem(output));
        actions.add(new Exit());

        new StartUI(output).init(input, (Store) memTracker, actions);
    }
}
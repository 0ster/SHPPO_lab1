package Factory;

import SubMenu.*;
import CoR.*;

public class MenuItem implements MenuItemAction {
    private CommandHandler commandHandler;

    public MenuItem(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void execute() {
        commandHandler.handleCoR("commandHandler");
    }
}

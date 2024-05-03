package Factory;

import SubMenu.*;

import java.util.ArrayList;
import java.util.List;

public class OpenFactory extends MenuFactory {
    @Override
    public List<MenuItemAction> createMenuItem() {
        List<MenuItemAction> menuItemActions = new ArrayList<>();
        OpenStrategy openStrategy = new OpenStrategy();
        openStrategy.setName("Открыть");
        menuItemActions.add(openStrategy);

        return menuItemActions;
    }
}

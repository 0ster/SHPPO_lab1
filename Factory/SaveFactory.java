package Factory;

import SubMenu.*;

import java.util.ArrayList;
import java.util.List;
public class SaveFactory extends MenuFactory {
    @Override
    public List<MenuItemAction> createMenuItem() {
        List<MenuItemAction> menuItemActions = new ArrayList<>();

        SaveAllStrategy saveAllStrategy = new SaveAllStrategy();
        SaveAsStrategy saveAsStrategy = new SaveAsStrategy();

        saveAllStrategy.setName("Сохранить все");
        saveAsStrategy.setName("Сохранить как");

        menuItemActions.add(saveAllStrategy);
        menuItemActions.add(saveAsStrategy);

        return menuItemActions;
    }

}

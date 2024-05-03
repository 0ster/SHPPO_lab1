package Factory;

import SubMenu.*;

import java.util.ArrayList;
import java.util.List;
public class DeleteFactory extends MenuFactory {
    @Override
    public List<MenuItemAction> createMenuItem() {
        List<MenuItemAction> menuItemActions = new ArrayList<>();

        DeleteAllStrategy deleteAllStrategy = new DeleteAllStrategy();
        DeleteLastChangeStrategy deleteLastChangeStrategy = new DeleteLastChangeStrategy();

        deleteAllStrategy.setName("Удалить все");
        deleteLastChangeStrategy.setName("Удалить последние изменения");

        menuItemActions.add(deleteAllStrategy);
        menuItemActions.add(deleteLastChangeStrategy);

        return menuItemActions;
    }

}

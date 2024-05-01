package Factory;

import SubMenu.DeleteAllStrategy;
import SubMenu.DeleteLastChangeStrategy;
import SubMenu.MenuItemAction;
import SubMenu.DeleteItemAction1;

public class DeleteFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        CompositeMenuItem deleteMenu = new CompositeMenuItem();
        deleteMenu.addMenuItem(new DeleteLastChangeStrategy("Удалить последнее"));
        deleteMenu.addMenuItem(new DeleteAllStrategy("Удалить все"));
        return deleteMenu;
    }

}

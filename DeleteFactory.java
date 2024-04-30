import SubMenu.DeleteItemAction;
import SubMenu.MenuItemAction;

public class DeleteFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        CompositeMenuItem deleteMenu = new CompositeMenuItem();
        deleteMenu.addMenuItem(new DeleteItemAction("Удалить"));
        return deleteMenu;
    }

}

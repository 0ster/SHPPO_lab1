import SubMenu.MenuItemAction;

public class SaveFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        CompositeMenuItem saveMenu = new CompositeMenuItem();
        saveMenu.addMenuItem(new SaveItemAction1("Сохранить"));
        return saveMenu;
    }
}

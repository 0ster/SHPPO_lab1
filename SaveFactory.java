public class SaveFactory extends MenuFactory{
    @Override
    public MenuItemAction createMenuItem() {
        CompositeMenuItem saveMenu = new CompositeMenuItem();
        saveMenu.addMenuItem(new SaveItemAction());
        return saveMenu;
    }
}

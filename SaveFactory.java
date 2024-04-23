public class SaveFactory extends MenuFactory{
    @Override
    public MenuItemAction createMenuItem() {
        return new SaveItemAction();
    }
}

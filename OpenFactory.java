public class OpenFactory extends MenuFactory{
    @Override
    public MenuItemAction createMenuItem() {
        return new OpenItemAction();
    }
}

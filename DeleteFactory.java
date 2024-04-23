public class DeleteFactory extends MenuFactory{
    @Override
    public MenuItemAction createMenuItem() {
        return new DeleteItemAction();
    }
}

public class ExpandedState implements MenuState{

    @Override
    public void handle(ContextMenu contextMenu) {
        System.out.println("Меню развернуто: ");
    }

    @Override
    public void clickMenuItem(MenuItemAction menuItem) {
        menuItem.execute();
    }
}

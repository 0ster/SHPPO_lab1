public class CollapsedState implements MenuState{

    @Override
    public void handle(ContextMenu contextMenu) {
        System.out.println("Меню свёрнуто: ");
    }

    @Override
    public void clickMenuItem(MenuItemAction menuItem) {}
}

public class DefaultMenuState implements MenuState{
    private ContextMenu menuItem;

    public DefaultMenuState(ContextMenu menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public void handleContextMenu() {
        System.out.println("Состояние по-умолчанию");
    }
}

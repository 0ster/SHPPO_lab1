public class ActiveMenuState implements MenuState {
    private ContextMenu menuItem;

    public ActiveMenuState(ContextMenu menuItem) {
        this.menuItem = menuItem;
    }

    @Override
    public void handleContextMenu() {
        System.out.println("Активное состояние");
    }
}

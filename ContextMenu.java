public class ContextMenu {
    private MenuState state;

    public ContextMenu() {
        this.state = new CollapsedState();
    }

    public void setState(MenuState state) {
        this.state = state;
    }

    public void handle() {
        state.handle(this);
    }

    public void clickMenuItem(MenuItemAction menuItem){
        state.clickMenuItem(menuItem);
    }


}

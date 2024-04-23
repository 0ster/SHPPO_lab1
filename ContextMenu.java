public class ContextMenu {
    private MenuState state;

    public void setState(MenuState state) {
        this.state = state;
    }

    public MenuState getState() {
        return state;
    }

    public void handle(){
        state.handle(this);
    }

    public void clickMenuItem(MenuItemAction menuItem){
        state.clickMenuItem(menuItem);
    }
}

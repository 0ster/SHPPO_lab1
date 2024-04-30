import SubMenu.MenuItemAction;

public class ContextMenu {
    private MenuState state;

    public ContextMenu() {}

    public ContextMenu(MenuState state) {
        this.state = state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }

    public MenuState getState() {
        return state;
    }

    public void handle() {state.handle();}

    public void clickMenuItem(MenuItemAction menuItem){
        state.clickMenuItem(menuItem);
    }


} // Полностью переписать это (пиздец))))))

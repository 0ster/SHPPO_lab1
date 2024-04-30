import SubMenu.MenuItemAction;

public interface MenuState {
    void handle();
    void clickMenuItem(MenuItemAction menuItem);
}

import SubMenu.MenuItemAction;

public interface MenuState {
    void stateHandle();
    void clickMenuItem(MenuItemAction menuItem);
}

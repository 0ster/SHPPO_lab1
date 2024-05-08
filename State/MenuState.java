package State;

import Strategy.MenuItemAction;

public interface MenuState {
    void stateHandle();
    void clickMenuItem(MenuItemAction menuItem);
}

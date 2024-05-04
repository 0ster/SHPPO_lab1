package State;

import SubMenu.MenuItemAction;

public class ExpandedState implements MenuState {

    @Override
    public void stateHandle() {
        System.out.println("Меню развернуто: ");
    }

    @Override
    public void clickMenuItem(MenuItemAction menuItem) {
        menuItem.execute();
    }
}

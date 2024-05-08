package State;

import Strategy.MenuItemAction;

public class ExpandedState implements MenuState {
    private String name;

    @Override
    public void stateHandle() {
        System.out.println("Меню развернуто: ");
    }

    @Override
    public void clickMenuItem(MenuItemAction menuItem) {
        menuItem.execute(name);
    }
}

package State;

import Strategy.MenuItemAction;

public class CollapsedState implements MenuState {

    @Override
    public void stateHandle() {
        System.out.println("Меню свёрнуто: ");
    }

    @Override
    public void clickMenuItem(MenuItemAction menuItem) {}
}

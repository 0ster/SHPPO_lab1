package Factory;

import SubMenu.MenuItemAction;

import java.util.List;

public abstract class MenuFactory {
    public abstract List<MenuItemAction> createMenuItem();
}

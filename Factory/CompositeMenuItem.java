package Factory;

import SubMenu.MenuItemAction;

import java.util.ArrayList;
import java.util.List;

public class CompositeMenuItem implements MenuItemAction {
    private List<MenuItemAction> menuItems = new ArrayList<>();

    public CompositeMenuItem(List<MenuItemAction> menuItems) {
        this.menuItems = menuItems;
    }

    public CompositeMenuItem() {
    }

    public void addMenuItem(MenuItemAction menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void execute() {
        // Выполняем все действия вложенных элементов меню
        for (MenuItemAction menuItem : menuItems) {
            menuItem.execute();
        }
    }

    public List<MenuItemAction> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemAction> menuItems) {
        this.menuItems = menuItems;
    }

}
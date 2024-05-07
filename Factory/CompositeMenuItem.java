package Factory;

import SubMenu.MenuItemAction;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CompositeMenuItem extends MenuFactory {
    private List<MenuFactory> menuItems = new ArrayList<>();

    public CompositeMenuItem(String name) {
        super(name);
    }

    public void addMenuItem(MenuFactory menuItem) {
        menuItems.add(menuItem);
    }

    // Удалить элемент из компоновщика
    public void remove(MenuFactory menuItem) {
        menuItems.remove(menuItem);
    }

    @Override
    public void display() {
        for (MenuFactory menuItem : menuItems) {
            menuItem.display();
        }
    }

}
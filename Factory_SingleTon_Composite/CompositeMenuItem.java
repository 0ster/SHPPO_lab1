package Factory_SingleTon_Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeMenuItem extends MenuItem {
    private List<MenuItem> menuItems = new ArrayList<>();
    private String name;

    public CompositeMenuItem(String name) {
        super(name);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    // Удалить элемент из компоновщика
    public void remove(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    @Override
    public void display() {
        System.out.println("Composite: " + name);
        for (MenuItem menuItem : menuItems) {
            menuItem.display();
        }
    }

}
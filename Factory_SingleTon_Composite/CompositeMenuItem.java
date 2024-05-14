package Factory_SingleTon_Composite;

import Publisher_Subscribe.ContextMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompositeMenuItem extends MenuItem {
    private List<MenuItem> menuItems = new ArrayList<>();

    public CompositeMenuItem(String name) {
        super(name);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public void removeMenuItem(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    @Override
    public void display() {
        System.out.println("Root: " + getName());
        for (MenuItem item : menuItems) {
            item.display();
        }
    }

    @Override
    public void select(ContextMenu publisher) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер элемента меню: \n");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= menuItems.size()) {
            MenuItem selectedItem = menuItems.get(choice - 1);
            selectedItem.display();
            selectedItem.select(publisher);
        } else {
            System.out.println("Invalid choice");
        }
    }

    @Override
    public void addChild(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    @Override
    public void removeChild(MenuItem menuItem) {
        menuItems.remove(menuItem);
    }

    public MenuItem findMenuItem(String name) {

        for (MenuItem item : menuItems) {
            if (item.getName().equals(name)) {
                return item;
            }

            if (item instanceof CompositeMenuItem) {
                MenuItem foundItem = ((CompositeMenuItem) item).findMenuItem(name);
                if (foundItem != null) {
                    return foundItem;
                }
            }
        }
        return null;
    }

    public void removeChild(String parentName, String childName) {
        MenuItem parentItem = findMenuItem(parentName);

        if (parentItem != null && parentItem instanceof CompositeMenuItem) {
            CompositeMenuItem parent = (CompositeMenuItem) parentItem;
            for (MenuItem item : parent.menuItems) {
                if (item.getName().equals(childName)) {
                    parent.removeChild(item);
                    System.out.println("Удален элемент '" + childName + "'");
                    return;
                }
            }
            System.out.println("Дочерний элемент '" + childName + "' не найден в '" + parentName + "'.");
        } else {
            System.out.println("Родительский элемент '" + parentName + "' не найдено.");
        }
    }
}
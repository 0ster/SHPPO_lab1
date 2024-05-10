package Factory_SingleTon_Composite;

import Publisher_Subscribe.ContextMenu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

//    @Override
//    public void display() {
//        System.out.println("Composite: " + name);
//        for (MenuItem menuItem : menuItems) {
//            menuItem.display();
//        }
//    }


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
        System.out.print("Enter the number of the item to select: ");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= menuItems.size()) {
            MenuItem selectedItem = menuItems.get(choice - 1);
            selectedItem.display();
            selectedItem.select(publisher);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    public MenuItem getItem(int index) {
        return menuItems.get(index);
    }

    public int getItemCount() {
        return menuItems.size();
    }
}
package Factory;

import SubMenu.LeafStrategy;
import SubMenu.MenuItemAction;

public class LeafFactory extends MenuFactory {
    private String name;
    private static LeafFactory instance;

    private LeafFactory(String name) {
        super(name);
    }

    @Override
    public MenuFactory getInstance(String name) {
        return new LeafFactory(name);
    }

    @Override
    public void display() {
        System.out.println("Leaf: " + name);
        MenuItemAction item = new LeafStrategy();
        item.execute(name);
    }
}


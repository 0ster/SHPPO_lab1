package Factory;

import SubMenu.MenuItemAction;

import java.util.List;

public abstract class MenuFactory {
    private String name;
    private static MenuFactory instance;

    public MenuFactory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void display();

    public MenuFactory getInstance(String name) {
        if (instance == null) {
            instance = new MenuFactory(name) {
                public void display() {
                }
            };
        }
        return instance;
    }
}

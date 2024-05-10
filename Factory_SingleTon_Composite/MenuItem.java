package Factory_SingleTon_Composite;

import Publisher_Subscribe.ContextMenu;

public abstract class MenuItem {
    private String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void display();

    public abstract void select(ContextMenu publisher);
}

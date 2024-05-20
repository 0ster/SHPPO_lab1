package org.example.Factory_SingleTon_Composite;

import org.example.Publisher_Subscribe.ContextMenu;

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

    public abstract void addChild(MenuItem menuItem);

    public abstract void removeChild(MenuItem menuItem);
}

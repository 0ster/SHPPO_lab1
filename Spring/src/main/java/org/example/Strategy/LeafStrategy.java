package org.example.Strategy;

public class LeafStrategy implements MenuItemAction {

    private String name;

    public LeafStrategy() {
        name = " ";
    }
    public LeafStrategy(String name) {
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public void execute(String name) {
        System.out.println("Выполняется: " + name);
    }

}
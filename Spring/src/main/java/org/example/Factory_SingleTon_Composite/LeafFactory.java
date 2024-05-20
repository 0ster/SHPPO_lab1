package org.example.Factory_SingleTon_Composite;

public class LeafFactory extends MenuItemFactory {
    private static LeafFactory instance;

    private LeafFactory(String name) {
        super(name);
    }

    public static LeafFactory getInstance(String name) {
        if (instance == null) {
            instance = new LeafFactory(name) {
                public void display() {
                }
            };
        }
        return instance;
    }

    @Override
    public MenuItem createMenuItem(String name) {
        return new Leaf(name);
    }

}


package Factory_SingleTon_Composite;

abstract class MenuItemFactory {
    private String name;

    public MenuItemFactory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract MenuItem createMenuItem(String name);
}


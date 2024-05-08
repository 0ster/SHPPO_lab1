package Strategy;

public class LeafStrategy implements MenuItemAction {

    private String Name;

    public LeafStrategy() {
        Name = " ";
    }
    public LeafStrategy(String name) {
        Name = name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }

    @Override
    public void execute(String name) {
        System.out.println("Выполняется " + name);
    }

}
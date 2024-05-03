package SubMenu;

public class OpenStrategy implements OpenItemAction1 {

    private String Name;

    public OpenStrategy() {
        Name = " ";
    }
    public OpenStrategy(String name) {
        Name = name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getName() {
        return Name;
    }


    @Override
    public void open() {
        System.out.println("Выполняется открытие...");
    }

    @Override
    public void execute() {
        open();
    }
}

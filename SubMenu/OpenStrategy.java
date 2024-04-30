package SubMenu;

public class OpenStrategy implements OpenItemAction1 {

    private String Name;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void open() {
        System.out.println("Выполняется сохранение всего...");
    }

    @Override
    public void execute() {
        open();
    }
}

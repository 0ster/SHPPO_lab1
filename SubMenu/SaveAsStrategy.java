package SubMenu;

public class SaveAsStrategy implements SaveItemAction1 {

    private String Name;

    public SaveAsStrategy() {
        Name = " ";
    }

    public SaveAsStrategy(String name) {
        this.Name = name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void save() {
        System.out.println("Выполняется сохранение как...");
    }

    @Override
    public void execute() {
        save();
    }
}
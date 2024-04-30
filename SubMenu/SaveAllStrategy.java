package SubMenu;

public class SaveAllStrategy implements SaveItemAction1 {

    private String Name;

    public SaveAllStrategy(String name) {
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
        System.out.println("Выполняется сохранение всего...");
    }

    @Override
    public void execute() {
        save();
    }
}
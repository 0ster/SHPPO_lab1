package SubMenu;

public class DeleteAllStrategy implements DeleteItemAction1 {

    private String Name;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void delete() {
        System.out.println("Выполняется удаление всего...");
    }

    @Override
    public void execute() {
        delete();
    }
}
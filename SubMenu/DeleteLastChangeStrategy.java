package SubMenu;

public class DeleteLastChangeStrategy implements DeleteItemAction1 {

    private String Name;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void delete() {
        System.out.println("Выполняется удаление последнего выбора...");
    }

    @Override
    public void execute() {
        delete();
    }
}
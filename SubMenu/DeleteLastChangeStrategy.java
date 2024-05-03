package SubMenu;

public class DeleteLastChangeStrategy implements DeleteItemAction1 {

    private String Name;

    public DeleteLastChangeStrategy() {
        Name = " ";
    }

    public DeleteLastChangeStrategy(String name) {
        Name = name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    @Override
    public void delete() {
        System.out.println("Выполняется удаление последнего изменения...");
    }

    @Override
    public void execute() {
        delete();
    }
}
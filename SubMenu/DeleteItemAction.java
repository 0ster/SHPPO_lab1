package SubMenu;

public class DeleteItemAction implements MenuItemAction {
    private MenuItemAction deleteStrategy;

    private String Name;
    public DeleteItemAction(String Name) {
        this.Name = Name;
    }

    public DeleteItemAction() {

    }

    public void setDeleteStrategy(MenuItemAction deleteStrategy) {
        this.deleteStrategy = deleteStrategy;
    }

    public void delete() {
        execute();
    }

    @Override
    public void execute() {

    }
}//Сделать интерфейсом

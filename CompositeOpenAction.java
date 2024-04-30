import SubMenu.MenuItemAction;


public class CompositeOpenAction implements MenuItemAction{
    private MenuItemAction openAction;


    public CompositeOpenAction(MenuItemAction openAction) {
        this.openAction = openAction;
    }

    @Override
    public void execute() {
        // Сначала выполняем "Сохранение как..."
        openAction.execute();

    }

    public MenuItemAction getOpenAction() {
        return openAction;
    }

    public void setOpenAction(MenuItemAction openAction) {
        this.openAction = openAction;
    }
}

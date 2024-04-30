import SubMenu.MenuItemAction;

public class CompositeDeleteAction implements MenuItemAction {

    private MenuItemAction deleteAllAction;
    private MenuItemAction deleteLastChangeAction;

    public CompositeDeleteAction(MenuItemAction deleteAllAction, MenuItemAction deleteLastChangeAction) {
        this.deleteAllAction = deleteAllAction;
        this.deleteLastChangeAction = deleteLastChangeAction;
    }

    @Override
    public void execute() {
        // Сначала выполняем "Сохранение как..."
        deleteAllAction.execute();
        // Затем выполняем "Сохранение всего..."
        deleteLastChangeAction.execute();
    }

    public MenuItemAction getDeleteAllAction() {
        return deleteAllAction;
    }

    public void setDeleteAllAction(MenuItemAction deleteAllAction) {
        this.deleteAllAction = deleteAllAction;
    }

    public MenuItemAction getDeleteLastChangeAction() {
        return deleteLastChangeAction;
    }

    public void setDeleteLastChangeAction(MenuItemAction deleteLastChangeAction) {
        this.deleteLastChangeAction = deleteLastChangeAction;
    }
}

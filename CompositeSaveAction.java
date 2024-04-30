import SubMenu.MenuItemAction;

// Создаем класс для комбинированного действия "Сохранение как... и сохранение всего"
public class CompositeSaveAction implements MenuItemAction {
    private MenuItemAction saveAsAction;
    private MenuItemAction saveAllAction;

    public CompositeSaveAction(MenuItemAction saveAsAction, MenuItemAction saveAllAction) {
        this.saveAsAction = saveAsAction;
        this.saveAllAction = saveAllAction;
    }

    @Override
    public void execute() {
        // Сначала выполняем "Сохранение как..."
        saveAsAction.execute();
        // Затем выполняем "Сохранение всего..."
        saveAllAction.execute();
    }

    public MenuItemAction getSaveAsAction() {
        return saveAsAction;
    }

    public void setSaveAsAction(MenuItemAction saveAsAction) {
        this.saveAsAction = saveAsAction;
    }

    public MenuItemAction getSaveAllAction() {
        return saveAllAction;
    }

    public void setSaveAllAction(MenuItemAction saveAllAction) {
        this.saveAllAction = saveAllAction;
    }

}

package Factory;

import SubMenu.*;

public class DeleteFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        DeleteAllStrategy deleteAllStrategy = new DeleteAllStrategy();
        DeleteLastChangeStrategy deleteLastChangeStrategy = new DeleteLastChangeStrategy();
        deleteAllStrategy.setName("Удалить все");
        deleteLastChangeStrategy.setName("Удалить последние изменения");
        String name1 = deleteAllStrategy.getName();
        System.out.println(name1);
        String name2 = deleteLastChangeStrategy.getName();
        System.out.println(name2);

        CompositeMenuItem saveMenu = new CompositeMenuItem();
        saveMenu.addMenuItem(deleteAllStrategy);
        saveMenu.addMenuItem(deleteLastChangeStrategy);
        return saveMenu;
    }

}

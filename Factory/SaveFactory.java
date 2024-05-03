package Factory;

import SubMenu.*;

import javax.xml.namespace.QName;

public class SaveFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        SaveAllStrategy saveAllStrategy = new SaveAllStrategy();
        SaveAsStrategy saveAsStrategy = new SaveAsStrategy();
        saveAllStrategy.setName("Сохранить все");
        saveAsStrategy.setName("Сохранить как");
        String name1 = saveAsStrategy.getName();
        System.out.println(name1);
        String name2 = saveAllStrategy.getName();
        System.out.println(name2);

        CompositeMenuItem saveMenu = new CompositeMenuItem();
        saveMenu.addMenuItem(saveAllStrategy);
        saveMenu.addMenuItem(saveAsStrategy);
        return saveMenu;
    }

}

package Factory;

import SubMenu.MenuItemAction;
import SubMenu.SaveAllStrategy;
import SubMenu.SaveAsStrategy;
import SubMenu.SaveItemAction1;

import javax.xml.namespace.QName;

public class SaveFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        CompositeMenuItem saveMenu = new CompositeMenuItem();
        saveMenu.addMenuItem(new SaveAsStrategy("Сохранить как"));
        saveMenu.addMenuItem(new SaveAllStrategy("Сохранить все"));
        return saveMenu;
    }

}

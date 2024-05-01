package Factory;

import SubMenu.*;

import javax.xml.namespace.QName;

public class OpenFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        OpenStrategy openStrategy = new OpenStrategy();
        openStrategy.setName("Открыть");
        String name = openStrategy.getName();
        System.out.println(name);

        CompositeMenuItem openMenu = new CompositeMenuItem();
        openMenu.addMenuItem(openStrategy);
        return openMenu;
    }
}

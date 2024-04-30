import SubMenu.MenuItemAction;
import SubMenu.OpenStrategy;

public class OpenFactory extends MenuFactory {
    @Override
    public MenuItemAction createMenuItem() {
        return new OpenStrategy();
    }
}

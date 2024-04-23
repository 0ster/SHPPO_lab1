import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        MenuFactory openFactory = new OpenFactory();
        MenuItemAction openItem = openFactory.createMenuItem();

        MenuFactory saveFactory = new SaveFactory();
        MenuItemAction saveItem = saveFactory.createMenuItem();

        MenuFactory deleteFactory = new DeleteFactory();
        MenuItemAction deleteItem = deleteFactory.createMenuItem();

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.handle();

        contextMenu.setState(new ExpandedState());
        contextMenu.handle();

        contextMenu.clickMenuItem(openItem);
    }
}

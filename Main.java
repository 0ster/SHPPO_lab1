import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        MenuFactory openFactory = new OpenFactory();
        MenuItemAction openItem = openFactory.createMenuItem();


        SaveItemAction saveAction = new SaveItemAction();
        saveAction.setSaveStrategy(new SaveAsStrategy());
        saveAction.execute();
        saveAction.setSaveStrategy(new SaveAllStrategy());
        saveAction.execute();

        DeleteItemAction deleteAction = new DeleteItemAction();
        deleteAction.setDeleteStrategy(new DeleteLastChangeStrategy());
        deleteAction.delete();
        deleteAction.setDeleteStrategy(new DeleteAllStrategy());
        deleteAction.delete();

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.handle();

        contextMenu.setState(new ExpandedState());
        contextMenu.handle();

        contextMenu.clickMenuItem(openItem);
    }
}

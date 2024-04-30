import SubMenu.*;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Выберете кнопачку. Благодарим хоззяина за выбор"); // Для состояния
        System.out.println("кнопочка 1) свернуто");
        System.out.println("кнопочка 2) развернуто");

        ContextMenu contextMenu = new ContextMenu();

        Scanner input = new Scanner(System.in);
        int KnopochkaState = input.nextInt();

        switch (KnopochkaState) {
            case 1:

                contextMenu.setState(new ExpandedState());
                contextMenu.handle();

                MenuFactory openFactory = new OpenFactory();
                MenuFactory saveFactory = new SaveFactory();
                MenuFactory deleteFactory = new DeleteFactory();

                MenuItemAction openItem = openFactory.createMenuItem();
                MenuItemAction saveItem = saveFactory.createMenuItem();
                MenuItemAction deleteItem = deleteFactory.createMenuItem();

                contextMenu.clickMenuItem(openItem);
                contextMenu.clickMenuItem(saveItem);
                contextMenu.clickMenuItem(deleteItem);

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
                break;
            case 2:
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}

import CoR.*;
import Factory.*;
import SubMenu.*;

import java.util.List;
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

                List<MenuItemAction> openItems = openFactory.createMenuItem();
                List<MenuItemAction> saveItems = saveFactory.createMenuItem();
                List<MenuItemAction> deleteItems = deleteFactory.createMenuItem();

                CommandHandler openHandler = new OpenCommandHandler();
                CommandHandler saveHandler = new SaveCommandHandler();
                CommandHandler deleteHandler = new DeleteCommandHandler();
                CommandHandler saveAs = new SaveAsCommandHandler();
                CommandHandler saveAll = new SaveAllCommandHandler();
                CommandHandler deleteLastChange = new DeleteLastChangeCommandHandler();
                CommandHandler deleteAll = new DeleteAllCommandHandler();

                openHandler.setNext(saveHandler);
                saveHandler.setNext(deleteHandler);
                deleteHandler.setNext(saveAs);
                saveAs.setNext(saveAll);
                saveAll.setNext(deleteLastChange);
                deleteLastChange.setNext(deleteAll);
                openHandler.setNext(saveHandler);


                // Создание элементов компоновщика
                MenuItemAction openMenuItem = new MenuItem(openHandler);
                MenuItemAction saveMenuItem = new MenuItem(saveHandler);
                MenuItemAction deleteMenuItem = new MenuItem(deleteHandler);
                MenuItemAction saveAsMenuItem = new MenuItem(saveAs);
                MenuItemAction saveAllMenuItem = new MenuItem(saveAll);
                MenuItemAction deleteLastChangeMenuItem = new MenuItem(deleteLastChange);
                MenuItemAction deleteAllMenuItem = new MenuItem(deleteAll);

                contextMenu.clickMenuItem(openItems);
                contextMenu.clickMenuItem(saveItems);
                contextMenu.clickMenuItem(deleteItems);

                CompositeMenuItem all = new CompositeMenuItem();
                all.addMenuItem(openMenuItem);
                all.addMenuItem(saveMenuItem);
                all.addMenuItem(deleteMenuItem);
                all.addMenuItem(saveAsMenuItem);
                all.addMenuItem(saveAllMenuItem);
                all.addMenuItem(deleteLastChangeMenuItem);
                all.addMenuItem(deleteAllMenuItem);

                // Вызов операции на компоновщике
                all.execute();

                break;
            case 2:
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}

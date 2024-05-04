import CoR.*;
import Factory.*;
import State.*;
import SubMenu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберете кнопачку. Благодарим хоззяина за выбор"); // Для состояния
        System.out.println("кнопочка 1) свернуто");
        System.out.println("кнопочка 2) развернуто");

        Scanner input = new Scanner(System.in);
        int knopochkaState = input.nextInt();

        ContextMenu contextMenu = new ContextMenu();

        switch (knopochkaState) {
            case 1:
                // Установка состояния "развернуто"
                contextMenu.setState(new ExpandedState());
                contextMenu.handle();

                // Создание фабрик для элементов подменю
                MenuFactory openFactory = new OpenFactory();
                MenuFactory saveFactory = new SaveFactory();
                MenuFactory deleteFactory = new DeleteFactory();

                // Получение элементов подменю из фабрик
                List<MenuItemAction> openItems = openFactory.createMenuItem();
                List<MenuItemAction> saveItems = saveFactory.createMenuItem();
                List<MenuItemAction> deleteItems = deleteFactory.createMenuItem();

                // Создание обработчиков команд
                CommandHandler menuRoot = new MenuRoot();
                CommandHandler openHandler = new OpenCommandHandler();
                CommandHandler saveHandler = new SaveCommandHandler();
                CommandHandler deleteHandler = new DeleteCommandHandler();
                CommandHandler saveAs = new SaveAsCommandHandler();
                CommandHandler saveAll = new SaveAllCommandHandler();
                CommandHandler deleteLastChange = new DeleteLastChangeCommandHandler();
                CommandHandler deleteAll = new DeleteAllCommandHandler();

                menuRoot.handleCoR("Root");
                openHandler.handleCoR("open");
                saveHandler.handleCoR("save");
                saveAs.handleCoR("saveAs");
                saveAll.handleCoR("saveAll");
                deleteHandler.handleCoR("delete");
                deleteLastChange.handleCoR("deleteLastChange");
                deleteAll.handleCoR("deleteAll");

                // Настройка цепочки обработчиков команд
                menuRoot.setNext(openHandler);
                openHandler.setNext(saveHandler);
                saveHandler.setNext(deleteHandler);
                deleteHandler.setNext(saveAs);
                saveAs.setNext(saveAll);
                saveAll.setNext(deleteLastChange);
                deleteLastChange.setNext(deleteAll);
                openHandler.setNext(saveHandler);

                // Создание элементов меню
                MenuItemAction openMenuItem = new MenuItem(openHandler);
                MenuItemAction saveMenuItem = new MenuItem(saveHandler);
                MenuItemAction deleteMenuItem = new MenuItem(deleteHandler);
                MenuItemAction saveAsMenuItem = new MenuItem(saveAs);
                MenuItemAction saveAllMenuItem = new MenuItem(saveAll);
                MenuItemAction deleteLastChangeMenuItem = new MenuItem(deleteLastChange);
                MenuItemAction deleteAllMenuItem = new MenuItem(deleteAll);

                System.out.println("Выберете элемент меню"); // Для состояния

                Scanner in = new Scanner(System.in);
                String item = in.nextLine();

                switch (item) {
                    case "open":
                        contextMenu.clickMenuItem(openItems);
                        break;
                    case "save":
                        contextMenu.clickMenuItem(saveItems);
                        break;
                    case "delete":
                        contextMenu.clickMenuItem(deleteItems);
                        break;
                    // Добавьте остальные кейсы для других команд меню
                    default:
                        System.out.println("Неподдерживаемая команда меню: " + item);
                        break;
                }
//                menuRoot.handleCoR("saveAs");
                // Создание составного элемента меню1

                CompositeMenuItem all = new CompositeMenuItem();
                List<MenuItemAction> menuItems = new ArrayList<>();

                menuItems.add(openMenuItem);
                menuItems.add(saveMenuItem);
                menuItems.add(deleteMenuItem);
                menuItems.add(saveAsMenuItem);
                menuItems.add(saveAllMenuItem);
                menuItems.add(deleteLastChangeMenuItem);
                menuItems.add(deleteAllMenuItem);

                all.execute();
                all.setMenuItems(menuItems);

//                System.out.println(all);


                break;
            case 2:
                // Установка состояния "свернуто"
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}


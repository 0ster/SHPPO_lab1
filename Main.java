
import Factory_SingleTon_Composite.CompositeMenuItem;
import Factory_SingleTon_Composite.LeafFactory;
import Factory_SingleTon_Composite.MenuItem;
import Publisher_Subscribe.ContextMenu;
import Publisher_Subscribe.User;
import State.*;
import Strategy.LeafStrategy;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Выберете развернуть/свернуть");
        System.out.println("    1) развернуть");
        System.out.println("    2) свернуть");

        Scanner input = new Scanner(System.in);
        int stateButton = input.nextInt();

        ContextMenu contextMenu = new ContextMenu();

        switch (stateButton) {
            case 1:
                contextMenu.setState(new ExpandedState());
                contextMenu.handle();

                User user = new User();

                LeafFactory factory = LeafFactory.getInstance("Фабрика 1");

                MenuItem item2 = factory.createMenuItem("2");
                MenuItem item3 = factory.createMenuItem("3");
                MenuItem item5 = factory.createMenuItem("5");
                MenuItem item6 = factory.createMenuItem("6");

                CompositeMenuItem primalRoot = new CompositeMenuItem("Первоначальный корень");
                CompositeMenuItem menu = new CompositeMenuItem("Menu");
                CompositeMenuItem item1 = new CompositeMenuItem("1");
                CompositeMenuItem item4 = new CompositeMenuItem("4");

                primalRoot.addMenuItem(menu);

                menu.addMenuItem(item1);
                menu.addMenuItem(item4);

                item1.addMenuItem(item2);
                item1.addMenuItem(item3);
                item4.addMenuItem(item5);
                item4.addMenuItem(item6);

                menu.display();

                Scanner scanner = new Scanner(System.in);
                boolean running = true;
                while (running) {
                    System.out.println("Выберите действие:");
                    System.out.println("1. Подписаться на пункт меню");
                    System.out.println("2. Отписаться от пункта меню");
                    System.out.println("3. Показать подписанные пункты");
                    System.out.println("4. Добавить новый пункт в меню");
                    System.out.println("5. Удалить пункт из меню");
                    System.out.println("6. Активировать все подписанные пункты");
                    System.out.println("7. Выйти");

                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("Введите название пункта меню для подписки:");
                            String subscribeItemName = scanner.nextLine();
                            MenuItem subscribeItem = primalRoot.findMenuItem(subscribeItemName);
                            LeafStrategy itemAction = new LeafStrategy();
                            if (subscribeItem != null) {
                                contextMenu.subscribe(user, subscribeItem);
                                System.out.println("Подписка на пункт " + subscribeItemName + " выполнена.");
                            } else {
                                System.out.println("Пункт меню не найден.");
                            }
                            break;
                        case 2:
                            System.out.println("Введите название пункта меню для отписки:");
                            String unsubscribeItemName = scanner.nextLine();
                            MenuItem unsubscribeItem = primalRoot.findMenuItem(unsubscribeItemName);
                            if (unsubscribeItem != null) {
                                contextMenu.unsubscribe(user, unsubscribeItem);
                                System.out.println("Отписка от пункта " + unsubscribeItemName + " выполнена.");
                            } else {
                                System.out.println("Пункт меню не найден.");
                            }
                            break;
                        case 3:
                            user.displaySubscribedItems();
                            break;
                        case 4:
                            System.out.println("Введите название родительского элемента:");
                            String parentName = scanner.next();

                            MenuItem addParentItem = primalRoot.findMenuItem(parentName);

                            if (addParentItem != null) {

                                System.out.println("Выбери тип нового элемента \n 1)Root \n 2)Leaf");
                                Scanner inty = new Scanner(System.in);
                                int type = inty.nextInt();

                                switch (type){
                                   case 1:
                                       System.out.println("Введите название нового элемента:");
                                       String newItemName1 = scanner.next();

                                       LeafFactory newLeaf = LeafFactory.getInstance(newItemName1);
                                       CompositeMenuItem newItem = new CompositeMenuItem(newItemName1);

                                       addParentItem.addChild(newItem);
                                       System.out.println("Добавлен " + newItemName1 + " в " + parentName);

                                       menu.display();
                                       break;
                                   case 2:
                                       System.out.println("Введите название нового элемента:");
                                       String newItemName2 = scanner.next();

                                       LeafFactory newLeaf1 = LeafFactory.getInstance(newItemName2);
                                       MenuItem newItem1 = factory.createMenuItem(newItemName2);

                                       addParentItem.addChild(newItem1);
                                       System.out.println("Добавлен " + newItemName2 + " в " + parentName);

                                       menu.display();
                                       break;
                               }
                            }
                            else {
                                System.out.println("Родительский элемент не найден.");
                            }
                            break;
                        case 5:
                            System.out.println("Введите название родительского элемента:");
                            String deleteParentName = scanner.next();

                            MenuItem parentItem = menu.findMenuItem(deleteParentName);

                            if (parentItem != null) {

                                System.out.println("Введите название дочернего элемента, который требуется удалить:");
                                String childName = scanner.next();

                                primalRoot.removeChild(deleteParentName, childName);
                            } else {
                                System.out.println("Родительский элемент не найден.");
                            }
                            menu.display();
                            break;
                        case 6:
                            user.updateSubscribedItem();
                            break;
                        case 7:
                            running = false;
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }

                break;
            case 2:
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}


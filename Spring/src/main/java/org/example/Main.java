package org.example;

import org.example.Factory_SingleTon_Composite.*;
import org.example.Publisher_Subscribe.*;
import org.example.State.*;
import org.example.Strategy.LeafStrategy;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        IContextMenu contextMenu = context.getBean("contextMenu", IContextMenu.class);
        User user = context.getBean("user", User.class);
        LeafFactory factory = context.getBean("leafFactory", LeafFactory.class);
        CompositeMenuItem primalRoot = context.getBean("compositeMenuItem", CompositeMenuItem.class);

        System.out.println("Выберете развернуть/свернуть");
        System.out.println("    1) развернуть");
        System.out.println("    2) свернуть");

        Scanner input = new Scanner(System.in);
        int stateButton = input.nextInt();

        switch (stateButton) {
            case 1:
                contextMenu.setState(context.getBean("expandedState", ExpandedState.class));
                contextMenu.handle();

                MenuItem item2 = factory.createMenuItem("2");
                MenuItem item3 = factory.createMenuItem("3");
                MenuItem item5 = factory.createMenuItem("5");
                MenuItem item6 = factory.createMenuItem("6");

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

//                Producer producer = new Producer(primalRoot, factory);
//                Consumer consumer = new Consumer(primalRoot);
////
//                Thread producerThread = new Thread(producer);
//                Thread consumerThread = new Thread(consumer);
//
////                producerThread.start();
////                consumerThread.start();
                Thread producerThread = null;
                Thread consumerThread = null;
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
                            System.out.println("Производитель добавляет новый элемент в очередь.");
                            Producer producer = new Producer(primalRoot, factory);
                            Consumer consumer = new Consumer(primalRoot);

                            producerThread = new Thread(producer);
                            consumerThread = new Thread(consumer);

                            producerThread.start();
                            consumerThread.start();

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
                            if (producerThread != null) {
                                producerThread.interrupt();
                            }
                            if (consumerThread != null) {
                                consumerThread.interrupt();
                            }
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }

                break;
            case 2:
                contextMenu.setState(context.getBean("collapsedState", CollapsedState.class));
                contextMenu.handle();
                break;
        }
    }
}



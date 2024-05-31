package org.example;

import org.example.Factory_SingleTon_Composite.*;
import org.example.Publisher_Subscribe.*;
import org.example.State.*;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.ApplicationContext;

public class Menu {

    private final ApplicationContext context;
    private final IContextMenu contextMenu;
    private final User user;
    private final LeafFactory factory;
    private final CompositeMenuItem primalRoot;
    private final Scanner scanner;

    public Menu(ApplicationContext context) {
        this.context = context;
        this.contextMenu = context.getBean("contextMenu", IContextMenu.class);
        this.user = context.getBean("user", User.class);
        this.factory = context.getBean("leafFactory", LeafFactory.class);
        this.primalRoot = context.getBean("compositeMenuItem", CompositeMenuItem.class);
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("Выберете развернуть/свернуть");
        System.out.println("    1) развернуть");
        System.out.println("    2) свернуть");

        int stateButton = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (stateButton) {
            case 1:
                expandMenu();
                break;
            case 2:
                collapseMenu();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void expandMenu() {
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

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(primalRoot, factory, queue);
        Consumer consumer = new Consumer(primalRoot);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        Choices(queue, producerThread, consumerThread, menu);
    }

    private void collapseMenu() {
        contextMenu.setState(context.getBean("collapsedState", CollapsedState.class));
        contextMenu.handle();
    }

    private void Choices(BlockingQueue<String> queue, Thread producerThread, Thread consumerThread, CompositeMenuItem menu) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    Subscription();
                    break;
                case 2:
                    Unsubscription();
                    break;
                case 3:
                    user.displaySubscribedItems();
                    break;
                case 4:
                    AddMenuItem(queue, menu);
                    break;
                case 5:
                    RemoveMenuItem(menu);
                    break;
                case 6:
                    user.updateSubscribedItem();
                    break;
                case 7:
                    running = false;
                    queue.offer("EXIT");
                    try {
                        producerThread.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    consumerThread.interrupt();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    private void printMainMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Подписаться на пункт меню");
        System.out.println("2. Отписаться от пункта меню");
        System.out.println("3. Показать подписанные пункты");
        System.out.println("4. Добавить новый пункт в меню");
        System.out.println("5. Удалить пункт из меню");
        System.out.println("6. Активировать все подписанные пункты");
        System.out.println("7. Выйти");
        System.out.print("Введите действие: ");
    }

    private void Subscription() {
        System.out.println("Введите название пункта меню для подписки:");
        String subscribeItemName = scanner.nextLine();
        MenuItem subscribeItem = primalRoot.findMenuItem(subscribeItemName);
        if (subscribeItem != null) {
            contextMenu.subscribe(user, subscribeItem);
            System.out.println("Подписка на пункт " + subscribeItemName + " выполнена.");
        } else {
            System.out.println("Пункт меню не найден.");
        }
    }

    private void Unsubscription() {
        System.out.println("Введите название пункта меню для отписки:");
        String unsubscribeItemName = scanner.nextLine();
        MenuItem unsubscribeItem = primalRoot.findMenuItem(unsubscribeItemName);
        if (unsubscribeItem != null) {
            contextMenu.unsubscribe(user, unsubscribeItem);
            System.out.println("Отписка от пункта " + unsubscribeItemName + " выполнена.");
        } else {
            System.out.println("Пункт меню не найден.");
        }
    }

    private void AddMenuItem(BlockingQueue<String> queue, CompositeMenuItem menu) {
        System.out.println("Введите название родительского элемента:");
        String parentName = scanner.nextLine();
        queue.offer(parentName);

        System.out.println("Выберите тип нового элемента: 1)Root 2)Leaf");
        queue.offer(scanner.nextLine());

        System.out.println("Введите название нового элемента:");
        queue.offer(scanner.nextLine());
        menu.display();
    }

    private void RemoveMenuItem(CompositeMenuItem menu) {
        System.out.println("Введите название родительского элемента:");
        String deleteParentName = scanner.nextLine();
        MenuItem parentItem = menu.findMenuItem(deleteParentName);

        if (parentItem != null) {
            System.out.println("Введите название дочернего элемента, который требуется удалить:");
            String childName = scanner.nextLine();

            primalRoot.removeChild(deleteParentName, childName);
        } else {
            System.out.println("Родительский элемент не найден.");
        }
        menu.display();
    }
}


import Factory_SingleTon_Composite.CompositeMenuItem;
import Factory_SingleTon_Composite.LeafFactory;
import Factory_SingleTon_Composite.MenuItem;
import Publisher_Subscribe.ContextMenu;
import Publisher_Subscribe.User;
import State.*;

import java.util.Scanner;

/////////////////////////////////////
//...1)...НАПИСАТЬ РЕВЕРСИВНУЮ ПРОХОДКУ ПО ДЕРЕВУ, НАДЕЮСЬ НЕ ЗАБУДЕМ.......
//........Отдельный метод в компоновщике
//...2)...НАПИСАТЬ ВЗАИМОЗАМЕНЯЕМУЮ ФУНКЦИЮ ПОДПИСКИ/ОТПИСКИ.......
//...3)...ДОБАВЛЕНИЕ УДАЛЕНИЕ ЭЛЕМЕНТОВ + БАЗОВАЯ МОДЕЛЬ......
//...4)...СПИСОК ДЛЯ ВЫВОДА ЭЛЕМЕНТОВ С ПОДПИСКОЙ......
//...5)...
/////////////////////////////////////

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

                System.out.println("Введите имя: ");
                Scanner in = new Scanner(System.in);
                String name = in.nextLine();

                User user = new User(name, contextMenu);

                contextMenu.subscribe(user);

                LeafFactory factory = LeafFactory.getInstance("Factory 1");

//                MenuItem item1 = factory.createMenuItem("Leaf Item 1");
                MenuItem item2 = factory.createMenuItem("2");
                MenuItem item3 = factory.createMenuItem("3");
//                MenuItem item4 = factory.createMenuItem("Leaf Item 4");
                MenuItem item5 = factory.createMenuItem("5");
                MenuItem item6 = factory.createMenuItem("6");

                CompositeMenuItem composite = new CompositeMenuItem("Composite 1");

                CompositeMenuItem menu = new CompositeMenuItem("Menu");
                CompositeMenuItem item1 = new CompositeMenuItem("Item 1");
                CompositeMenuItem item4 = new CompositeMenuItem("Item 4");

                // Добавляем элементы в компоновщик

                item1.addMenuItem(item2);
                item1.addMenuItem(item3);
                item4.addMenuItem(item5);
                item4.addMenuItem(item6);

                menu.addMenuItem(item1);
                menu.addMenuItem(item4);

                // Отображаем меню
                menu.display();
                menu.select(contextMenu);
                break;
            case 2:
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}


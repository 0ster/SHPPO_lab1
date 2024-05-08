
import Factory_SingleTon_Composite.CompositeMenuItem;
import Factory_SingleTon_Composite.LeafFactory;
import Factory_SingleTon_Composite.MenuItem;
import Publisher_Subscribe.ContextMenu;
import Publisher_Subscribe.User;
import State.*;

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

                LeafFactory factory = LeafFactory.getInstance("Factory 1");

                MenuItem item1 = factory.createMenuItem("Leaf Item 1");
                MenuItem item2 = factory.createMenuItem("Leaf Item 2");
                MenuItem item3 = factory.createMenuItem("Leaf Item 3");

                CompositeMenuItem composite = new CompositeMenuItem("Composite 1");

                CompositeMenuItem menu = new CompositeMenuItem("Menu");
                CompositeMenuItem submenu = new CompositeMenuItem("Submenu");


                // Добавляем элементы в компоновщик
                submenu.addMenuItem(item2);
                submenu.addMenuItem(item3);

                menu.addMenuItem(item1);
                menu.addMenuItem(submenu);

                // Отображаем меню
                menu.display();

                User user = new User("Antonio Banderas", contextMenu);
                contextMenu.setLeafStrategy(" l") ;
                break;
            case 2:
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}


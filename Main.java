
import Factory.*;
import Publisher_Subscribe.ContextMenu;
import State.*;
import SubMenu.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберете кнопачку. Благодарим хоззяина за выбор");
        System.out.println("кнопочка 1) разврнуто");
        System.out.println("кнопочка 2) свернуто");

        Scanner input = new Scanner(System.in);
        int knopochkaState = input.nextInt();

        ContextMenu contextMenu = new ContextMenu();

        switch (knopochkaState) {
            case 1:
                // Установка состояния "развернуто"
                contextMenu.setState(new ExpandedState());
                contextMenu.handle();

                break;
            case 2:

                // Установка состояния "свернуто"
                contextMenu.setState(new CollapsedState());
                contextMenu.handle();
                break;
        }
    }
}


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int menuChoice;
        System.out.println("Выберите тип файла: ");
        System.out.println("1. Текстовый документ");
        System.out.println("2. Изображение");
        menuChoice = in.nextInt();

        switch (menuChoice) {
            case 1:
                MenuFactory documentMenu = new DocumentMenuFactory();
                documentMenu.showMenu();
                System.out.println("Меню текстового документа: ");
                documentMenu.createMenu();
                break;
            case 2:
                MenuFactory imageMenu = new ImageMenuFactory();
                imageMenu.showMenu();
                System.out.println("Меню изображения: ");
                imageMenu.createMenu();
                break;
            default:
                System.out.println("Некорректный выбор меню");
                break;
        }
    }
}

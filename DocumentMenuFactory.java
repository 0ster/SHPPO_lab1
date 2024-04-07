import java.util.Scanner;

public class DocumentMenuFactory extends MenuFactory {
    DocumentMenu doc = new DocumentMenu();
    public Menu showMenu() {
        doc.showMenu();
        return null;
    }

    public Options createMenu(){
        doc.open();
        doc.save();
        doc.delete();
        doc.copy();

        int optionChoice;

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите опцию меню: ");
        optionChoice = in.nextInt();

        switch (optionChoice){
            case 1:
                doc.open();
                System.out.println("Выполняется открытие текстового документа...");
                break;
            case 2:
                doc.save();
                System.out.println("Выполняется сохранение текстового документа...");
                break;
            case 3:
                doc.delete();
                System.out.println("Выполняется удаление текстового документа...");
                break;
            case 4:
                doc.copy();
                System.out.println("Выполняется копирование выделенного текста...");
                break;
            default:
                System.out.println("Некорректный выбор опции");
                break;
        }

        return new DocumentMenu();
    }
}

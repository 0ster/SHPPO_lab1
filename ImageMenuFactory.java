import java.util.Scanner;

public class ImageMenuFactory extends MenuFactory{
    ImageMenu image = new ImageMenu();

    public Menu showMenu() {
        image.showMenu();
        return null;
    }

    public Options createMenu(){
        image.open();
        image.save();
        image.delete();
        image.resize();

        int optionChoice;

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите опцию меню: ");
        optionChoice = in.nextInt();

        switch (optionChoice){
            case 1:
                image.open();
                System.out.println("Выполняется открытие изображения...");
                break;
            case 2:
                image.save();
                System.out.println("Выполняется сохранение изображения...");
                break;
            case 3:
                image.delete();
                System.out.println("Выполняется удаление изображения...");
                break;
            case 4:
                image.resize();
                System.out.println("Выполняется изменение размера изображения...");
                break;
            default:
                System.out.println("Некорректный выбор опции");
                break;
        }

        return new ImageMenu();
    }
}

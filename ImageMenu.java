public class ImageMenu implements Options, Menu{

    @Override
    public void showMenu() {System.out.println("Открыть меню изображения");}

    @Override
    public void open() {
        System.out.println("1. Открыть изображение");
    }

    @Override
    public void save() {
        System.out.println("2. Сохранить изображение");
    }

    @Override
    public void delete() {
        System.out.println("3. Удалить изображение");
    }
    public void resize(){
        System.out.println("4. Изменить размер изображения");
    }
}

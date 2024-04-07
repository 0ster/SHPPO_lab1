public class DocumentMenu implements Options, Menu{

    @Override
    public void showMenu() {System.out.println("Открыть меню текстового документа");}

    @Override
    public void open() {
        System.out.println("1. Открыть текстовый документ");
    }

    @Override
    public void save() {
        System.out.println("2. Сохранить текстовый документ");
    }

    @Override
    public void delete() {System.out.println("3. Удалить текстовый документ");}

    public void copy(){
        System.out.println("4. Копировать выделенный текст");
    }
}

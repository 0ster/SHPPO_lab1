package CoR;

public class SaveAsCommandHandler extends SaveCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("saveAs")) {
            // Обработка команды сохранения всех файлов
            System.out.println("Сохранение как");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "SaveAsCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

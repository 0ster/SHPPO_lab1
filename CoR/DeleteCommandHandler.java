package CoR;

public class DeleteCommandHandler extends BaseCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("delete")) {
            // Обработка команды сохранения всех файлов
            System.out.println("Удаление");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }
}

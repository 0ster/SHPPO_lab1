package CoR;

public class OpenCommandHandler extends BaseCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("open")) {
            // Обработка команды сохранения
            System.out.println("Открытие");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }
}

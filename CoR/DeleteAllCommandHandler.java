package CoR;

public class DeleteAllCommandHandler extends DeleteCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("deleteAll")) {
            // Обработка команды сохранения всех файлов
            System.out.println("Удаление всего");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "DeleteAllCommandHandler{}";
    }
}

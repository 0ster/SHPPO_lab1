package CoR;

public class DeleteLastChangeCommandHandler extends DeleteCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("deleteLastChange")) {
            // Обработка команды сохранения всех файлов
            System.out.println("Удаление последнего изменения");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "DeleteLastChangeCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

package CoR;

public class SaveAllCommandHandler extends SaveCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("saveAll")) {
            // Обработка команды сохранения всех файлов
            System.out.println("Сохранение всего");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "SaveAllCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

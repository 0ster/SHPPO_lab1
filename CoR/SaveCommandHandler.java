package CoR;

public class SaveCommandHandler  extends BaseCommandHandler{

    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("save")) {
            // Обработка команды сохранения всех файлов
            System.out.println("Сохранение");
        } else if (nextHandler != null) {
            // Если текущий обработчик не может обработать команду, передаем ее следующему обработчику
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "SaveCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

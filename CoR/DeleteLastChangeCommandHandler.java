package CoR;

public class DeleteLastChangeCommandHandler extends DeleteCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("deleteLastChange")) {
            // Обработка команды сохранения
            System.out.println("Удаление последнего изменения");
        } else {
            super.handleCoR(command);
        }
    }
}

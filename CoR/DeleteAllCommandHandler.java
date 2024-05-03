package CoR;

public class DeleteAllCommandHandler extends DeleteCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("deleteAll")) {
            // Обработка команды сохранения
            System.out.println("Удаление всего");
        } else {
            super.handleCoR(command);
        }
    }
}

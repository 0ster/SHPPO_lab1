package CoR;

public class SaveAllCommandHandler extends SaveCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("saveAll")) {
            // Обработка команды сохранения
            System.out.println("Сохранение всего");
        }
        else {
            super.handleCoR(command);
        }
    }
}

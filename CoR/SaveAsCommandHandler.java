package CoR;

public class SaveAsCommandHandler extends SaveCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("saveAs")) {
            // Обработка команды сохранения
            System.out.println("Сохранение как");
        } else {
            super.handleCoR(command);
        }
    }
}

package CoR;

public class SaveAllCommandHandler extends SaveCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("saveAll")) {
            System.out.println("  Сохранение всего");
        } else if (nextHandler != null) {
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

package CoR;

public class SaveCommandHandler  extends BaseCommandHandler{

    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("save")) {
            System.out.println("-Сохранение");
        } else if (nextHandler != null) {
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

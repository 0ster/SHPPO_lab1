package CoR;

public class OpenCommandHandler extends BaseCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("open")) {
            System.out.println("-Открытие");
        } else if (nextHandler != null) {
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "OpenCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

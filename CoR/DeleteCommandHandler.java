package CoR;

public class DeleteCommandHandler extends BaseCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("delete")) {
            System.out.println("-Удаление");
        } else if (nextHandler != null) {
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "DeleteCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

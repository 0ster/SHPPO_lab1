package CoR;

public class DeleteAllCommandHandler extends DeleteCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("deleteAll")) {
            System.out.println("  Удаление всего");
        } else if (nextHandler != null) {
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "DeleteAllCommandHandler{}";
    }
}

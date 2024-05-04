package CoR;

public class DeleteLastChangeCommandHandler extends DeleteCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("deleteLastChange")) {
            System.out.println("  Удаление последнего изменения");
        } else if (nextHandler != null) {
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "DeleteLastChangeCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

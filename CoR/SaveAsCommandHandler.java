package CoR;

public class SaveAsCommandHandler extends SaveCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("saveAs")) {
            System.out.println("  Сохранение как");
        } else if (nextHandler != null) {
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }

    @Override
    public String toString() {
        return "SaveAsCommandHandler{" +
                "nextHandler=" + nextHandler +
                '}';
    }
}

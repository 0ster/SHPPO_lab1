package CoR;

public class MenuRoot extends BaseCommandHandler{
    @Override
    public void handleCoR(String command) {
        if (command.equalsIgnoreCase("Root")) {
            System.out.println(" ");
        } else if (nextHandler != null) {
            nextHandler.handleCoR(command);
        } else {
            System.out.println("Команда не поддерживается");
        }
    }


}

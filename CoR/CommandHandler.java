package CoR;

public interface CommandHandler {
    void handleCoR(String command);
    void setNext(CommandHandler nextHandler);
}

package CoR;

abstract class BaseCommandHandler implements CommandHandler {
    protected CommandHandler nextHandler;

    @Override
    public void setNext(CommandHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public abstract void handleCoR(String command);
}

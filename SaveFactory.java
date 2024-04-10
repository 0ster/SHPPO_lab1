public class SaveFactory extends MenuFactory{
    @Override
    public Options createMenuItem() {
        return new SaveOption();
    }
}

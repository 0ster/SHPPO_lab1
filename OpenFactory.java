public class OpenFactory extends MenuFactory{
    @Override
    public Options createMenuItem() {
        return new OpenOption();
    }
}

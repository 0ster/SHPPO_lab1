public class DeleteFactory extends MenuFactory{
    @Override
    public Options createMenuItem() {
        return new DeleteOption();
    }
}

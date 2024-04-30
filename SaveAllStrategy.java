public class SaveAllStrategy implements SaveStrategy {
    @Override
    public void execute() {
        System.out.println("Выполняется сохранение всего...");
    }
}
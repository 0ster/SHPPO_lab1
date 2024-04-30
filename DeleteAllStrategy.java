public class DeleteAllStrategy implements DeleteStrategy {
    @Override
    public void execute() {
        System.out.println("Выполняется полное удаление...");
    }
}
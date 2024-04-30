public class DeleteLastChangeStrategy implements DeleteStrategy {
    @Override
    public void execute() {
        System.out.println("Выполняется удаление последнего изменения...");
    }
}
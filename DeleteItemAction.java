public class DeleteItemAction implements MenuItemAction {
    private DeleteStrategy deleteStrategy;

    public void setDeleteStrategy(DeleteStrategy deleteStrategy) {
        this.deleteStrategy = deleteStrategy;
    }

    @Override
    public void execute() {
        if (deleteStrategy != null) {
            deleteStrategy.execute();
        } else {
            System.out.println("Не установлена стратегия удаления.");
        }
    }
    public void delete() {
        execute();
    }

}

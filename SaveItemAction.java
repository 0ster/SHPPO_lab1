public class SaveItemAction implements MenuItemAction {
    private SaveStrategy saveStrategy;

    // Метод для установки стратегии сохранения
    public void setSaveStrategy(SaveStrategy saveStrategy) {
        this.saveStrategy = saveStrategy;
    }

    @Override
    public void execute() {
        if (saveStrategy != null) {
            saveStrategy.execute();
        } else {
            System.out.println("Не установлена стратегия сохранения.");
        }
    }

}
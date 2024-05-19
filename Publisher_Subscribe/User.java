package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;
import Strategy.LeafStrategy;

import java.util.ArrayList;
import java.util.List;

public class User implements Subscriber {
    private List<MenuItem> subscribedItems = new ArrayList<>();
    private LeafStrategy strategy = new LeafStrategy();

    @Override
    public void update(MenuItem item) {
        System.out.println("Подписчик: Получено обновление для " + item.getName());
        subscribedItems.add(item);
    }

    public void updateSubscribedItem() {
        List<MenuItem> itemsToExecute = new ArrayList<>(subscribedItems);
        for (MenuItem item : itemsToExecute) {
            strategy.execute(item.getName()); // Call the execute method from LeafStrategy
        }
    }

    @Override
    public void displaySubscribedItems() {
        System.out.println("Элементы подписки: ");
        for (MenuItem item : subscribedItems) {
            System.out.println("- " + item.getName());
        }
    }

    @Override
    public void removeSubscribedItem(MenuItem item) {
        subscribedItems.remove(item);
    }

    @Override
    public void setStrategy(LeafStrategy strategy) {
        this.strategy = strategy;
    }

    public List<MenuItem> getSubscribedItems() {
        return subscribedItems;
    }
}

package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;

import java.util.ArrayList;
import java.util.List;
import Strategy.MenuItemAction;

public class User implements Subscriber {
    private List<MenuItem> subscribedItems = new ArrayList<>();
    private MenuItemAction strategy;

    @Override
    public void update(MenuItem item) {
        System.out.println("Подписчик: Получено обновление для " + item.getName());
        subscribedItems.add(item);
        if (strategy != null) {
            strategy.execute(item.getName());
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
    public void setStrategy(MenuItemAction strategy) {
        this.strategy = strategy;
    }
}

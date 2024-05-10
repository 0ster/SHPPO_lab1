package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;
import State.MenuState;
import Strategy.MenuItemAction;

import java.util.ArrayList;
import java.util.List;

public class ContextMenu implements Publisher {

    private List<Subscriber> subscribers = new ArrayList<>();
    private MenuItemAction leafStrategy;
    private MenuState state;
    private String newsSub;

    public void setLeafStrategy(String news, MenuItem item) {
        this.newsSub = news;
        notifySubscribers(item);
    }

    public void displayItem(String name) {
        leafStrategy.execute(name);
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);

    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(MenuItem item) {
        for (Subscriber o : subscribers)
            o.update(item);
    }

    public ContextMenu() {}

    public ContextMenu(MenuState state) {
        this.state = state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }

    public MenuState getState() {
        return state;
    }

    public void handle() {state.stateHandle();}

    public void clickMenuItem(List<MenuItemAction> menuItems) {
        for (MenuItemAction menuItem : menuItems) {
            state.clickMenuItem(menuItem);
        }
    }

} // Полностью переписать это (пи)

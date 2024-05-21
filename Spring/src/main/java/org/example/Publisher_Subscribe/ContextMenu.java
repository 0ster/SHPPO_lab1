package org.example.Publisher_Subscribe;

import org.example.Factory_SingleTon_Composite.MenuItem;
import org.example.State.MenuState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextMenu implements Publisher {

    private Map<MenuItem, List<Subscriber>> subscriptions = new HashMap<>();
    private MenuState state;

    public ContextMenu() {
    }

    public ContextMenu(MenuState state) {
        this.state = state;
    }

    public void setState(MenuState state) {
        this.state = state;
    }

    public MenuState getState() {
        return state;
    }

    public void handle() {
        state.stateHandle();
    }

    @Override
    public void subscribe(Subscriber subscriber, MenuItem menuItem) {
        List<Subscriber> subscribers = subscriptions.getOrDefault(menuItem, new ArrayList<>());
        subscribers.add(subscriber);
        subscriptions.put(menuItem, subscribers);
        // Уведомляем подписчика сразу после подписки
        subscriber.update(menuItem);
    }

    @Override
    public void unsubscribe(Subscriber subscriber, MenuItem menuItem) {
        List<Subscriber> subscribers = subscriptions.get(menuItem);
        if (subscribers != null) {
            subscribers.remove(subscriber);
            if (subscribers.isEmpty()) {
                subscriptions.remove(menuItem);
            }
            if (subscriber instanceof User) {
                ((User) subscriber).removeSubscribedItem(menuItem);
            }
        }
    }

    @Override
    public void notifySubscribers(MenuItem menuItem) {
        List<Subscriber> subscribers = subscriptions.get(menuItem);
        if (subscribers != null) {
            for (Subscriber subscriber : subscribers) {
                subscriber.updateSubscribedItem();
            }
        }
    }
}


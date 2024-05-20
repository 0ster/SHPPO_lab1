package org.example.Publisher_Subscribe;

import org.example.Factory_SingleTon_Composite.MenuItem;
import org.example.Strategy.LeafStrategy;

public interface Subscriber {
    void update(MenuItem item);
    void displaySubscribedItems();
    void removeSubscribedItem(MenuItem item);
    void setStrategy(LeafStrategy strategy);
    void updateSubscribedItem();
}

package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;
import Strategy.LeafStrategy;

public interface Subscriber {
    void update(MenuItem item);
    void displaySubscribedItems();
    void removeSubscribedItem(MenuItem item);
    void setStrategy(LeafStrategy strategy);
    void updateSubscribedItem();
}

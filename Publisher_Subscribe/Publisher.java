package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;

public interface Publisher {
    void subscribe(Subscriber subscriber, MenuItem menuItem);
    void unsubscribe(Subscriber subscriber, MenuItem menuItem);
    void notifySubscribers(MenuItem item);
}

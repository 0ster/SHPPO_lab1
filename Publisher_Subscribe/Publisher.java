package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(MenuItem item);
}

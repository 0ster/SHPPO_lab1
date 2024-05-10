package Publisher_Subscribe;

import Factory_SingleTon_Composite.MenuItem;

public class User implements Subscriber {
    private String name;

    public User(String name, Publisher publisher) {
        this.name = name;
        publisher.subscribe(this);
    }

    @Override
    public void update(MenuItem item) {
        if (item != null) {
            item.display();}
//        System.out.println(name + " подписался на кнопочку " + item.getName());
    }
}

package Publisher_Subscribe;

public class User implements Subscriber {
    private String name;

    public User(String name, Publisher publisher) {
        this.name = name;
        publisher.subscribe(this);
    }

    @Override
    public void update(String news) {
        System.out.println(name + " подписался на кнопочку " + news);
    }
}

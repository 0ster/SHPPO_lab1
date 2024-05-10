package Factory_SingleTon_Composite;

import Publisher_Subscribe.ContextMenu;

public class Leaf extends MenuItem {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Leaf:_____________" + getName());
    }

    @Override
    public void select(ContextMenu publisher) {
        // Уведомляем подписчиков о выборе элемента
        publisher.notifySubscribers(null);
    }
}


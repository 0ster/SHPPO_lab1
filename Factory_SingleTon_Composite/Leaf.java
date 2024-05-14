package Factory_SingleTon_Composite;

import Publisher_Subscribe.ContextMenu;
import Strategy.LeafStrategy;

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
        publisher.notifySubscribers(this);
        LeafStrategy leaf = new LeafStrategy();
        leaf.execute(this.getName());
    }

    @Override
    public void addChild(MenuItem menuItem) {

        System.out.println("Невозможно добавить дочерний элемент.");
    }

    @Override
    public void removeChild(MenuItem menuItem) {

        System.out.println("Невозможно удалить дочерний элемент.");
    }
}


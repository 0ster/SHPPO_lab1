package Factory_SingleTon_Composite;

public class Leaf extends MenuItem {

    public Leaf(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("Leaf: " + getName());
    }
}


package org.example;

import org.example.Factory_SingleTon_Composite.CompositeMenuItem;
import org.example.Factory_SingleTon_Composite.LeafFactory;
import org.example.Factory_SingleTon_Composite.MenuItem;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private CompositeMenuItem root;
    private LeafFactory factory;
    private BlockingQueue<String> queue;

    public Producer(CompositeMenuItem root, LeafFactory factory, BlockingQueue<String> queue) {
        this.root = root;
        this.factory = factory;
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String parentName = queue.take(); // ожидание команды

                if (parentName.equals("EXIT")) {
                    break;
                }

                MenuItem addParentItem = findMenuItemRecursive(root, parentName);

                if (addParentItem != null) {
                    String type = queue.take(); // тип нового элемента

                    switch (type) {
                        case "1":
                            String newItemName1 = queue.take();
                            CompositeMenuItem newItem = new CompositeMenuItem(newItemName1);
                            addParentItem.addChild(newItem);
                            break;
                        case "2":
                            String newItemName2 = queue.take();
                            MenuItem newItemLeaf = factory.createMenuItem(newItemName2);
                            addParentItem.addChild(newItemLeaf);
                            break;
                    }
                } else {
                    System.out.println("Родительский элемент не найден.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private MenuItem findMenuItemRecursive(MenuItem current, String name) {
        if (current.getName().equals(name)) {
            return current;
        }
        if (current instanceof CompositeMenuItem) {
            for (MenuItem item : ((CompositeMenuItem) current).getMenuItems()) {
                MenuItem found = findMenuItemRecursive(item, name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }
}

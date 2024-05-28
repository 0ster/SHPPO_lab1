package org.example;

import org.example.Factory_SingleTon_Composite.CompositeMenuItem;
import org.example.Factory_SingleTon_Composite.MenuItem;

public class Consumer implements Runnable {
    private CompositeMenuItem root;

    public Consumer(CompositeMenuItem root) {
        this.root = root;
    }

    public void run() {
        while (true) {
            try {
                synchronized (MenuBuffer.class) {
                    MenuItem item = MenuBuffer.takeItem();
                    root.addMenuItem(item);
                    System.out.println("Добавлен элемент: " + item.getName());
                    root.display();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

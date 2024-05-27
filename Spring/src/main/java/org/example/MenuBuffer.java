package org.example;

import org.example.Factory_SingleTon_Composite.MenuItem;

import java.util.LinkedList;
import java.util.Queue;

public class MenuBuffer {
    private static final int BUFFER_SIZE = 10;
    private static final Queue<MenuItem> buffer = new LinkedList<>();

    public synchronized static void addItem(MenuItem item) throws InterruptedException {
        while (buffer.size() == BUFFER_SIZE) {
            MenuBuffer.class.wait();
        }
        buffer.add(item);
        MenuBuffer.class.notifyAll();
    }

    public synchronized static MenuItem takeItem() throws InterruptedException {
        while (buffer.isEmpty()) {
            MenuBuffer.class.wait();
        }
        MenuItem item = buffer.poll();
        MenuBuffer.class.notifyAll();
        return item;
    }
}


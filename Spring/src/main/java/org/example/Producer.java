package org.example;

import org.example.Factory_SingleTon_Composite.CompositeMenuItem;
import org.example.Factory_SingleTon_Composite.LeafFactory;
import org.example.Factory_SingleTon_Composite.MenuItem;

import java.util.Scanner;

public class Producer implements Runnable {
    private CompositeMenuItem root;
    private LeafFactory factory;

    public Producer(CompositeMenuItem root, LeafFactory factory) {
        this.root = root;
        this.factory = factory;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String parentName = scanner.next();

            MenuItem addParentItem = root.findMenuItem(parentName);

            if (addParentItem != null) {
                System.out.println("Выбери тип нового элемента \n 1)Root \n 2)Leaf");
                int type = scanner.nextInt();

                switch (type) {
                    case 1:
                        System.out.println("Введите название нового элемента:");
                        String newItemName1 = scanner.next();
                        CompositeMenuItem newItem = new CompositeMenuItem(newItemName1);
                        try {
                            MenuBuffer.addItem(newItem);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        System.out.println("Введите название нового элемента:");
                        String newItemName2 = scanner.next();
                        MenuItem newItemLeaf = factory.createMenuItem(newItemName2);
                        try {
                            MenuBuffer.addItem(newItemLeaf);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            } else {
                System.out.println("Родительский элемент не найден.");
            }
        }
    }
}

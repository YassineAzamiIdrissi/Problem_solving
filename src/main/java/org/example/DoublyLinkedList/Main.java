package org.example.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        for (int i = 1; i <= 10; ++i) {
            // list.insertFirst(i);
            list.insertLast(i);
        }
        list.display();
        System.out.println();
        // list.deleteFirst();
        // list.deleteLast();
        list.deleteAt(9);
        list.display();
    }
}

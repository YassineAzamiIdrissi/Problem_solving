package org.example.DoublyLinkedList;

public class DoublyLinkedList {
    Node head;

    public void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        newNode.prev = last;
    }

    public void insertAtPosition(int position, int data) {
        if (position == 0) {
            insertFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < position - 1) {
            temp = temp.next;
            currentIndex++;
        }
        if (temp == null) {
            System.out.println("Invalid index");
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is already empty... ");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("List is already empty... ");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
        temp.prev = null;
        temp = null;
    }

    public void deleteAt(int position) {
        if (head == null) {
            System.out.println("List is already empty... ");
            return;
        }
        if (position == 0) {
            deleteFirst();
            return;
        }
        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < position) {
            temp = temp.next;
            currentIndex++;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        // temp.prev == null... it means the first element...
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        temp = null;
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }

}

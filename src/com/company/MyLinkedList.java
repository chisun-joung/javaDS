package com.company;

public class MyLinkedList {
    private static class Node {
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public MyLinkedList() {
        head = new Node(0, null);
        tail = new Node(0,null);
        head.next = tail;
        tail.next = tail;
    }

    public int size() { return size; }

    public void add(int data){
        Node node = new Node(data, tail);

        Node cur = head;
        while( cur.next != tail){
            cur = cur.next;
        }
        cur.next = node;
        ++size;
    }

    public int get(int index){
        if (index < 0 || index >= size)
            throw new RuntimeException();

        Node node = head.next;
        for( int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new RuntimeException();
        Node prev = head;
        for(int i = 0; i < index; i++)
            prev = prev.next;

        Node temp = prev.next;
        prev.next = temp.next;
        --size;
        return temp.data;
    }

    public int set(int index, int data) {
        if (index < 0 || index >= size)
            throw new RuntimeException();

        Node node = head.next;
        for(int i=0; i< index; i++)
            node = node.next;

        int oldValue = node.data;
        node.data = data;
        return oldValue;
    }

    public void insert(int index, int data) {
        if ( index < 0 || index >= size)
            throw new RuntimeException();

        Node prev = head;
        for(int i = 0; i < index; i++)
            prev = prev.next;
        prev.next = new Node(data, prev.next);
        ++size;
    }
}

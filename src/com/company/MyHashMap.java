package com.company;

public class MyHashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int HASH_SIZE = 10;
    private Node[] tables;

    public MyHashMap() {
        tables = new Node[HASH_SIZE];
    }

    private int hashFunc(int key) {
        return key % HASH_SIZE;
    }

    public void  set(int key, int value) {
        Node node = new Node(key, value);
        int idx = hashFunc(key);

        node.next = tables[idx];
        tables[idx] = node;
    }
}

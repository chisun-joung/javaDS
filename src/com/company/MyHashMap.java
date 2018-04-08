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

    public int get(int key) {
        int idx = hashFunc(key);
        for (Node node = tables[idx]; node != null; node = node.next) {
            if (node.key == key)
                return node.value;
        }
        throw new RuntimeException();
    }

    public int remove(int key) {
        int idx = hashFunc(key);
        if (tables[idx] == null)
            throw new RuntimeException();

        Node prev = null;
        Node cur = null;

        for(cur=tables[idx]; cur !=null; cur = cur.next) {
            if(cur.key == key )
                break;
            prev = cur;
        }

        if (cur == null)
           throw new RuntimeException();

        if(prev == null) {
            tables[idx] = cur.next;
            cur.next = null;
            return cur.value;
        }

        prev.next = cur.next;
        cur.next = null;
        return cur.value;
    }
}

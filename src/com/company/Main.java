package com.company;

import java.io.IOException;

import java.util.HashMap;
import java.util.Random;

public class Main {



    public static void display_list(DoublyLinkedList l) {
        //
        System.out.print("\n[head]");
        for ( int i = 0; i < l.size(); i++)
            System.out.printf("->[%2d]",l.get(i));
        //
//         System.out.flush();
//        try{
//            System.in.read();
//        }catch (IOException e){
//
//        }
    }



    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        for(int i = 0; i < 5; i++)
        {
            list.add(i+1);
        }
        display_list(list);

        list.remove(2);
        display_list(list);
        list.set(2,3);
        display_list(list);
        list.insert(3,4);
        display_list(list);

        MyHashMap hashMap = new MyHashMap();

        for (int i = 0 ; i < 100 ; i++)
        {
            int r = new Random().nextInt();
            hashMap.set(i,r);
        }
        for (int i = 0 ; i < 10 ; i++)
        {
            int key = new Random().nextInt(100);
            System.out.printf("\n%d -> %d ", key , hashMap.get(key) );
        }

        BTree tree = new BTree();
        int [] a = { 1, 10, 7, 6, 3, 9, 2, 5, 8};
        for(int i = 0; i < a.length; i++)
            tree.insert(a[i]);


        tree.preorder();
        tree.inorder();
        tree.postorder();

        if(tree.contains(10))
            System.out.println("Tree has 10");

        if(!tree.contains(11))
            System.out.println("Tree doesn't have 11");


        tree.remove(10);
        tree.preorder();
        tree.inorder();
        tree.postorder();
    }
}

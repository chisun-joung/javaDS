package com.company;

import java.io.IOException;

import java.util.Random;

public class Main {



    public static void display_list(DoublyLinkedList l) {
        //
        System.out.print("[head]");
        for ( int i = 0; i < l.size(); i++)
            System.out.printf("->[%2d]",l.get(i));
        //
         System.out.flush();
        try{
            System.in.read();
        }catch (IOException e){

        }
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
            System.out.printf("%d -> %d \n", key , hashMap.get(key) );
        }


    }
}

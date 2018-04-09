package com.company;

public class BTree {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

    }

    private Node root;

    public int insert(int data) {
        Node node = new Node(data);

        if( root == null ) {
            root = node;
            return 0;
        }

        Node prev = null;
        Node cur  = root;
        while (cur != null ) {
            prev = cur;
            if( data < cur.data)
                cur = cur.left;
            else if ( data > cur.data)
                cur = cur.right;
            else
                return -1;
        }

        if (data < prev.data)
            prev.left = node;
        else
            prev.right = node;
        return 0;
    }

    private void __preorder(Node node) {
        if (node == null)
            return;
        System.out.print(" " + node.data);
        __preorder(node.left);
        __preorder(node.right);
    }

    public void preorder() {
        System.out.print(" Preorder:");
        __preorder(root);
        System.out.println();
    }

    private void __inorder(Node node) {
        if (node == null)
            return;
        __inorder(node.left);
        System.out.print(" " + node.data);
        __inorder(node.right);
    }

    public void inorder() {
        System.out.print("  Inorder:");
        __inorder(root);
        System.out.println();
    }

    private void __postorder(Node node) {
        if (node == null)
            return;
        __postorder(node.left);
        __postorder(node.right);
        System.out.print(" " + node.data);
    }

    public void postorder() {
        System.out.print("Postorder:");
        __postorder(root);
        System.out.println();
    }
}

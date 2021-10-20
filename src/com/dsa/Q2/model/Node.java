package com.dsa.Q2.model;

public class Node {
    int key;
    Node left, right;

    public Node() {
        Node root;
        root = null;
    }

    // Parameterized constructor to create a single node in the tree
    public Node(int item) {
        key = item;
        left = right = null;
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}
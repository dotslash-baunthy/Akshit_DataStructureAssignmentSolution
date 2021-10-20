package com.dsa.Q2.main;

import com.dsa.Q2.model.Node;
import com.dsa.Q2.service.BST;

public class Driver {
    
    // Root of Binary Tree
    Node root;

    Driver() {
        root = null;
    }
    
    public static void main(String[] args) {
        Driver tree = new Driver();
        tree.root = new Node(50);
        tree.root.setLeft(new Node(30));
        tree.root.setRight(new Node(60));
        tree.root.getLeft().setLeft(new Node(10));
        tree.root.getRight().setLeft(new Node(55));

        BST bst = new BST();

        Node headNode = bst.bstToSkewedTree(tree.root);
        if (headNode!= null) {
            bst.traverseSkewedTree(headNode);
        }
    }
}
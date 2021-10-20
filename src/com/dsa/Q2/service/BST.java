package com.dsa.Q2.service;

import com.dsa.Q2.model.*;

public class BST {

    static Node prevNode = null;
    static Node headNode = null;

    // Flatten the given BST into a right skewed tree
    public Node bstToSkewedTree(Node root) {

        // Base case, if tree is empty
        if (root == null) {
            return null;
        }

        bstToSkewedTree(root.getLeft());
        Node rightNode = root.getRight();

        // Check if root/head is not defined
        if (headNode == null) {
            headNode = root;
            root.setLeft(null);
            prevNode = root;
        } else {
            prevNode.setRight(root);
            root.setLeft(null);
            prevNode = root;
        }

        // Right node is now the tree to be worked on
        bstToSkewedTree(rightNode);
        return headNode;
    }

    // Traversing the right skewed tree
    public void traverseSkewedTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getKey() + " ");
        traverseSkewedTree(root.getRight());
    }
}

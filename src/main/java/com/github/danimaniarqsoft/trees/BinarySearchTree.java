package com.github.danimaniarqsoft.trees;

import com.github.danimaniarqsoft.utils.TreeNode;

public class BinarySearchTree {

    private TreeNode root = null;

    public TreeNode lookup(int value) {

        TreeNode currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                return currentNode;
            }

            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return null;
    }

    public BinarySearchTree insert(int value) {
        TreeNode newNode = new TreeNode(value, null, null);

        if (this.root == null) {
            this.root = newNode;
            return this;
        }

        TreeNode currentNode = this.root;

        while (currentNode != null) {

            if (value <= currentNode.getValue() && currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                return this;
            } else if (value <= currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue() && currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                return this;
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            }

        }
        return this;
    }

    public BinarySearchTree delete() {
        return this;
    }

    public BinarySearchTree traverse() {
        return this;
    }
}

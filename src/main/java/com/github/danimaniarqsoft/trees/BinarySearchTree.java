package com.github.danimaniarqsoft.trees;

import com.github.danimaniarqsoft.utils.TreeNode;
import com.github.danimaniarqsoft.utils.TreeOperations;

import lombok.Data;

@Data
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

    public BinarySearchTree remove(int value) {
        TreeNode currentNode = this.root;
        TreeNode parent = null;

        if (currentNode == null) {
            return this;
        }

        if (currentNode.getValue() == value) {
            this.root = null;
            return this;
        }

        while (currentNode != null) {
            if (currentNode.getValue() == value) {
                break;
            }
            parent = currentNode;
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        if (currentNode == null) {
            return this;
        }

        boolean isLeftChild = false;

        if (parent.getLeft() != null && parent.getLeft().getValue() == value) {
            isLeftChild = true;
        }

        // Case 1: Both Siblings are nulls
        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            return this;
        }

        // Case 2: Either Sibling is null but not both

        if (currentNode.getLeft() != null && currentNode.getRight() == null) {

            if (isLeftChild) {
                parent.setLeft(currentNode.getLeft());
            } else {
                parent.setRight(currentNode.getLeft());
            }

        } else if (currentNode.getRight() != null && currentNode.getLeft() == null) {
            if (isLeftChild) {
                parent.setLeft(currentNode.getRight());
            } else {
                parent.setRight(currentNode.getRight());
            }
        }
        // Case: The two Siblings are not null

        if (currentNode.getRight() != null && currentNode.getLeft() != null) {

            TreeNode minimum = currentNode.getRight();
            TreeNode minimunParent = currentNode;

            if (minimum.getLeft() == null) {
                if (isLeftChild) {
                    parent.setLeft(minimum.getRight());
                } else {
                    parent.setRight(minimum.getRight());
                }

            } else {
                while (minimum.getLeft() != null) {
                    minimunParent = minimum;
                    minimum = minimum.getLeft();
                }
                // swap minimum and node to remove
                minimunParent.setLeft(minimum.getRight());
                minimum.setRight(currentNode.getRight());
                minimum.setLeft(currentNode.getLeft());

                if (isLeftChild) {
                    parent.setLeft(minimum);
                } else {
                    parent.setRight(minimum);
                }
            }

        }

        return this;
    }

    public static TreeNode minimum(TreeNode node) {

        if (node == null) {
            return node;
        }

        while (node.getLeft() != null) {
            node = node.getLeft();
        }

        return node;
    }

    public BinarySearchTree traverse() {
        return this;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree
                .insert(54)
                .insert(32)
                .insert(42)
                .insert(36)
                .insert(44)
                .insert(51)
                .insert(7)
                .insert(42)
                .insert(6)
                .insert(14)
                .insert(16)
                .insert(76)
                .insert(62)
                .insert(59)
                .insert(63)
                .insert(69)
                .insert(86)
                .insert(80)
                .insert(87)
                .insert(97)
                .insert(5)
                .insert(8)
                .insert(10)
                .insert(12)
                .insert(2);
        System.out.println(TreeOperations.traversePreOrder(tree));
            tree.remove(7);
            tree.remove(42);
        System.out.println(TreeOperations.traversePreOrder(tree));
    }
}

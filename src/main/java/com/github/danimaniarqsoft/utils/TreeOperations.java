package com.github.danimaniarqsoft.utils;

import com.github.danimaniarqsoft.trees.BinarySearchTree;

public class TreeOperations {

    public static String traversePreOrder(BinarySearchTree tree) {

        TreeNode root = tree.getRoot();


        if (root == null) {
            return "";
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append(root.getValue());
    
        String pointerRight = "└──";
        String pointerLeft = (root.getLeft() != null) ? "└──" : "├──";

        traverseNodes(sb, "", pointerRight, root.getRight(), root.getLeft() != null);
        traverseNodes(sb, "", pointerLeft, root.getLeft(), false);
        
    
        return sb.toString();
    }

    public static void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node, 
  boolean hasRightSibling) {
    if (node != null) {
        sb.append("\n");
        sb.append(padding);
        sb.append(pointer);
        sb.append(node.getValue());

        StringBuilder paddingBuilder = new StringBuilder(padding);
        if (hasRightSibling) {
            paddingBuilder.append("│  ");
        } else {
            paddingBuilder.append("   ");
        }

        String paddingForBoth = paddingBuilder.toString();
        String pointerRight = "└──";



        String pointerLeft = (node.getLeft() != null) ? "└──" : "├──";

        traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), node.getLeft() != null);
        traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), false);
        
    }
}
}

package com.github.danimaniarqsoft.challenges.linkedlist;

import java.util.HashSet;
import com.github.danimaniarqsoft.list.ListNode;

/**
 * Challenge: Find the intersection node of two singly linked lists.
 * The intersection is defined by reference (memory address), not by value.
 */
public class LinkedListIntersection {

    /**
     * Finds intersection using a HashSet to store visited nodes.
     * * Time Complexity: O(M + N) - Where M and N are the lengths of the lists.
     * Space Complexity: O(M) - Stores all nodes of list A in a set.
     * * @param headA Head of the first list.
     * 
     * @param headB Head of the second list.
     * @return The intersecting ListNode or null if no intersection exists.
     */
    public ListNode getIntersectionNodeWithHashSet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        HashSet<ListNode> visitedNodes = new HashSet<>();

        // Record all nodes from List A
        ListNode currentA = headA;
        while (currentA != null) {
            visitedNodes.add(currentA);
            currentA = currentA.getNext();
        }

        // Check if any node in List B was already visited
        ListNode currentB = headB;
        while (currentB != null) {
            if (visitedNodes.contains(currentB)) {
                return currentB;
            }
            currentB = currentB.getNext();
        }

        return null;
    }

    /**
     * Finds intersection using the "Two-Pointer Switch" technique.
     * This method synchronizes the pointers by making them travel the same total
     * distance.
     * * Time Complexity: O(M + N)
     * Space Complexity: O(1) - Constant space, no extra data structures.
     * * @param headA Head of the first list.
     * 
     * @param headB Head of the second list.
     * @return The intersecting ListNode or null if no intersection exists.
     */
    public ListNode getIntersectionNodeOptimized(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode ptrA = headA;
        ListNode ptrB = headB;

        /*
         * Logic:
         * ptrA travels: ListA + ListB
         * ptrB travels: ListB + ListA
         * Both travel exactly the same total length (M+N).
         * By the second pass, they will meet at the intersection point.
         * If there is no intersection, they will meet at 'null' simultaneously.
         */
        while (ptrA != ptrB) {
            // If ptrA reaches the end, redirect to head of list B, else move next
            ptrA = (ptrA == null) ? headB : ptrA.getNext();

            // If ptrB reaches the end, redirect to head of list A, else move next
            ptrB = (ptrB == null) ? headA : ptrB.getNext();
        }

        return ptrA; // Can be the intersection node OR null
    }
}
package com.github.danimaniarqsoft.challenges.linkedlist;

import com.github.danimaniarqsoft.list.ListNode;

/**
 * Challenge: Reverse a Singly Linked List.
 * This class provides two solutions to reverse the node order of a linked list.
 */
public class ReverseListChallenge {

    /**
     * Reverses the list iteratively using three pointers.
     * This approach is highly memory-efficient as it does not use the call stack.
     * * Time Complexity: O(n) - Visits each node exactly once.
     * Space Complexity: O(1) - Uses only three pointers regardless of list size.
     * * @param head The current head of the list.
     * 
     * @return The new head of the reversed list.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        // Base case: if list is empty or has only one element
        if (current == null || current.getNext() == null) {
            return current;
        }

        while (current != null) {
            next = current.getNext(); // 1. Save the next node
            current.setNext(prev); // 2. Reverse the current node's pointer
            prev = current; // 3. Move the 'prev' pointer forward
            current = next; // 4. Move the 'current' pointer forward
        }

        return prev; // 'prev' ends up as the new head
    }

    /**
     * Reverses the list recursively.
     * This approach uses the implicit call stack to reach the end of the list
     * and re-wires the pointers as the recursion unwinds.
     * * Time Complexity: O(n) - Visits each node once.
     * Space Complexity: O(n) - Due to the recursion stack depth.
     * * @param head The current node being processed.
     * 
     * @return The new head (the original tail) of the reversed list.
     */
    public ListNode reverseRecursive(ListNode head) {

        // Base Case: If we reach the last node or the list is empty
        if (head == null || head.getNext() == null) {
            return head;
        }

        // 1. Traverse to the very end to find the new head
        ListNode newHead = reverseRecursive(head.getNext());

        // 2. Reverse the link: Make the next node's 'next' point back to current
        head.getNext().setNext(head);

        // 3. Break the original forward link to avoid cycles
        head.setNext(null);

        return newHead;
    }
}
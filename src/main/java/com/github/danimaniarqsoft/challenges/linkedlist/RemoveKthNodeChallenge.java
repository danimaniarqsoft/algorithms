package com.github.danimaniarqsoft.challenges.linkedlist;

import com.github.danimaniarqsoft.list.ListNode;

/**
 * Challenge: Remove the Kth node from the end of a singly linked list.
 * This implementation uses a one-pass algorithm with O(n) time complexity
 * and O(1) space complexity.
 */
public class RemoveKthNodeChallenge {

    /**
     * Removes the Kth node from the end of the list.
     * * @param head The start of the singly linked list.
     * 
     * @param k The position from the end (1-indexed).
     * @return The head of the modified list.
     */
    public ListNode removeKthFromEnd(ListNode head, int k) {

        // Basic validation for empty lists
        if (head == null) {
            return head;
        }

        /*
         * * 1. THE DUMMY NODE TECHNIQUE
         * We create a 'dummy' node pointing to the head. This is crucial for
         * cases where we need to remove the first node, as it gives us
         * a reference to the node 'before' the head.
         */
        ListNode dummy = new ListNode(-1);
        dummy.setNext(head);

        ListNode trailer = dummy;
        ListNode leader = dummy;

        /*
         * * 2. CREATE THE GAP
         * Move the 'leader' pointer k steps ahead. This creates a fixed
         * window of size K between the leader and the trailer.
         */
        for (int i = 0; i < k; i++) {
            leader = leader.getNext();
            // If k is larger than the list size, return the original list
            if (leader == null) {
                return head;
            }
        }

        /*
         * * 3. MOVE THE WINDOW
         * Advance both pointers until the leader reaches the last node.
         * Because of the K-sized gap, the trailer will land exactly
         * one node BEFORE the node that needs to be removed.
         */
        while (leader.getNext() != null) {
            leader = leader.getNext();
            trailer = trailer.getNext();
        }

        /*
         * * 4. REMOVE THE TARGET
         * Skip the target node by linking the trailer to the node
         * after the target.
         */
        trailer.setNext(trailer.getNext().getNext());

        // Return the true head (dummy.next handles cases where head was removed)
        return dummy.getNext();
    }
}
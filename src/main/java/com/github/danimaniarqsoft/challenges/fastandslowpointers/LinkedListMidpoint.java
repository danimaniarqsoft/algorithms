package com.github.danimaniarqsoft.challenges.fastandslowpointers;

import com.github.danimaniarqsoft.list.ListNode;

/**
 * Challenge: Find the middle node of a singly linked list.
 * * Performance:
 * - Time Complexity: O(n) - We traverse the list once.
 * - Space Complexity: O(1) - No extra data structures are used.
 */
public class LinkedListMidpoint {

    /**
     * Finds the midpoint of the list using the Tortoise and Hare strategy.
     * * In an odd-length list, it returns the exact middle node.
     * In an even-length list, it returns the second middle node (per standard
     * requirements like those found in LeetCode).
     * * @param head The start of the linked list.
     * 
     * @return The ListNode located at the midpoint, or null if the list is empty.
     */
    public ListNode findMidpoint(ListNode head) {
        // Guard clause for empty or single-node lists
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        /*
         * Logic:
         * Move 'slow' by 1 step and 'fast' by 2 steps.
         * By the time 'fast' reaches the end (null or last node),
         * 'slow' will be halfway through the list.
         */
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
}
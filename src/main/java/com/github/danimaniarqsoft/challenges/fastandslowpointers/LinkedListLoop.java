package com.github.danimaniarqsoft.challenges.fastandslowpointers;

import java.util.HashSet;
import com.github.danimaniarqsoft.list.ListNode;

/**
 * Challenge: Determine if a singly linked list contains a cycle.
 * A cycle occurs if a node can be reached again by continuously following the
 * next pointer.
 */
public class LinkedListLoop {

    /**
     * Detects a cycle using a HashSet to track visited nodes.
     * * Time Complexity: O(n) - Visits each node once.
     * Space Complexity: O(n) - In the worst case, stores all nodes in the set.
     * * @param head The starting node of the list.
     * 
     * @return true if there is a cycle, false otherwise.
     */
    public boolean hasCycleWithHash(ListNode head) {
        if (head == null)
            return false;

        HashSet<ListNode> visitedNodes = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            // If the node is already in the set, we've found a loop
            if (visitedNodes.contains(current)) {
                return true;
            }
            visitedNodes.add(current);
            current = current.getNext();
        }
        return false;
    }

    /**
     * Detects a cycle using Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
     * This is the optimized solution for constant space complexity.
     * * Time Complexity: O(n)
     * Space Complexity: O(1) - Uses only two pointers regardless of list size.
     * * @param head The starting node of the list.
     * 
     * @return true if there is a cycle, false otherwise.
     */
    public boolean hasCycleWithFloyds(ListNode head) {
        // A list with 0 or 1 nodes and no self-loop cannot have a cycle
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        /*
         * * Logic: The fast pointer moves twice as fast as the slow pointer.
         * If there is a cycle, the fast pointer will eventually 'lap'
         * the slow pointer inside the loop.
         */
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext(); // Move 1 step
            fast = fast.getNext().getNext(); // Move 2 steps

            // If pointers meet, a cycle exists
            if (slow == fast) {
                return true;
            }
        }

        // If fast reaches null, the list is linear
        return false;
    }
}
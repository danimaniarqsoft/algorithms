package com.github.danimaniarqsoft.challenges.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.list.ListNode;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Test suite for the Linked List Intersection challenge.
 * This class validates that the algorithm can find the merge point of two
 * singly linked lists that share a common suffix.
 */
class LinkedListIntersectionTest {

    private final LinkedListIntersection solution = new LinkedListIntersection();

    /**
     * Executes the intersection check for various list configurations.
     * * @param prefixA Values unique to the first list.
     * 
     * @param prefixB     Values unique to the second list.
     * @param common      Values shared by both lists starting from the
     *                    intersection.
     * @param expectedVal The value of the node where they meet (0 if no
     *                    intersection).
     * @param description Contextual name for the test scenario.
     */
    @ParameterizedTest(name = "{4}")
    @CsvFileSource(resources = "/intersect-list.csv", numLinesToSkip = 1)
    @DisplayName("Linked List Intersection Tests")
    void testIntersection(
            @ConvertWith(StringArrayConverter.class) int[] prefixA,
            @ConvertWith(StringArrayConverter.class) int[] prefixB,
            @ConvertWith(StringArrayConverter.class) int[] common,
            int expectedVal,
            String description) {

        // 1. ARRANGE: Create two lists that physically share the same 'common' node
        // objects.
        // We cannot simply build two identical lists; they must point to the same
        // memory.
        ListNode[] heads = buildIntersectingLists(prefixA, prefixB, common);
        ListNode headA = heads[0];
        ListNode headB = heads[1];

        // 2. ACT: Find the intersection node.
        ListNode result = solution.getIntersectionNodeOptimized(headA, headB);

        // 3. ASSERT: Verify the node value matches the expectation.
        if (expectedVal == 0) {
            assertNull(result, "Expected no intersection for: " + description);
        } else {
            // Check that a node was found and that it has the correct value.
            assertEquals(expectedVal, result.getVal(), "Wrong intersection node for: " + description);
        }
    }

    /**
     * Factory method that constructs two lists meeting at a shared suffix.
     * * @return A ListNode array where index 0 is Head A and index 1 is Head B.
     */
    private ListNode[] buildIntersectingLists(int[] pA, int[] pB, int[] common) {
        // First, build the shared suffix part.
        ListNode commonPart = buildList(common);

        // Attach the unique prefixes to the SAME commonPart node reference.
        ListNode headA = attachPrefix(pA, commonPart);
        ListNode headB = attachPrefix(pB, commonPart);

        return new ListNode[] { headA, headB };
    }

    /**
     * Helper to create a list from an array and link its tail to an existing
     * suffix.
     */
    private ListNode attachPrefix(int[] prefix, ListNode suffix) {
        if (prefix == null || prefix.length == 0)
            return suffix;

        ListNode head = new ListNode(prefix[0]);
        ListNode curr = head;
        for (int i = 1; i < prefix.length; i++) {
            curr.setNext(new ListNode(prefix[i]));
            curr = curr.getNext();
        }
        // Link the end of the prefix to the shared suffix.
        curr.setNext(suffix);
        return head;
    }

    /**
     * Standard utility to transform an array into a chain of ListNode objects.
     */
    private ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.setNext(new ListNode(arr[i]));
            curr = curr.getNext();
        }
        return head;
    }
}
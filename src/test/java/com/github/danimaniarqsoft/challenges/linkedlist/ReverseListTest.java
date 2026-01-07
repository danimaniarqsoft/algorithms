package com.github.danimaniarqsoft.challenges.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.list.ListNode;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Test suite for validating Linked List reversal algorithms.
 * It transforms flat CSV data into a pointer-based linked structure, 
 * executes the reversal, and validates the resulting sequence.
 */
class ReverseListTest {

    private final ReverseListChallenge solution = new ReverseListChallenge();

    /**
     * Parameterized test that executes the reversal logic for various scenarios.
     * * @param inputArr    Initial sequence of numbers (from CSV).
     * @param expectedArr The expected sequence after reversal (from CSV).
     * @param description Contextual name for the specific test case.
     */
    @ParameterizedTest(name = "{2}")
    @CsvFileSource(resources = "/reverse-list.csv", numLinesToSkip = 1)
    @DisplayName("Reverse Linked List Tests")
    void testReverseList(
            @ConvertWith(StringArrayConverter.class) int[] inputArr,
            @ConvertWith(StringArrayConverter.class) int[] expectedArr,
            String description) {

        // 1. ARRANGE: Transform the flat array into a Singly Linked List (Node-based)
        ListNode head = buildList(inputArr);

        // 2. ACT: Invoke the recursive reversal implementation
        ListNode reversedHead = solution.reverseRecursive(head);

        // 3. ASSERT: Serialize the linked list back to a String for easy comparison
        String actualResult = listToString(reversedHead);
        String expectedResult = arrayToString(expectedArr);

        assertEquals(expectedResult, actualResult, 
            String.format("Reversal failed for scenario: %s", description));
    }

    /**
     * Factory method to create a Singly Linked List from an array.
     * [1, 2, 3] becomes (1) -> (2) -> (3) -> null
     */
    private ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.setNext(new ListNode(arr[i]));
            current = current.getNext();
        }
        return head;
    }

    /**
     * Traverses the linked list and converts values into a comma-separated string.
     * Essential for comparing the actual list state against expected results.
     */
    private String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.getVal()).append(head.getNext() != null ? "," : "");
            head = head.getNext();
        }
        return sb.toString();
    }

    /**
     * Utility to convert an array to a comma-separated string format.
     */
    private String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(i < arr.length - 1 ? "," : "");
        }
        return sb.toString();
    }
}
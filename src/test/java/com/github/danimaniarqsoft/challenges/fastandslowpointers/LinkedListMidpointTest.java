package com.github.danimaniarqsoft.challenges.fastandslowpointers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.list.ListNode;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Test suite for finding the midpoint of a Singly Linked List.
 */
class LinkedListMidpointTest {

    private final LinkedListMidpoint solution = new LinkedListMidpoint();

    @ParameterizedTest(name = "{2}")
    @CsvFileSource(resources = "/linked-list-midpoint.csv", numLinesToSkip = 1)
    @DisplayName("Midpoint Detection Tests")
    void testFindMidpoint(
            @ConvertWith(StringArrayConverter.class) int[] inputArr,
            int expectedVal,
            String description) {

        // 1. Arrange: Build the list from the array
        ListNode head = buildList(inputArr);

        // 2. Act: Find the middle node
        ListNode midpoint = solution.findMidpoint(head);

        // 3. Assert: Verify the midpoint is not null and has the correct value
        assertNotNull(midpoint, "Midpoint should not be null for: " + description);
        assertEquals(expectedVal, midpoint.getVal(), "Incorrect midpoint for: " + description);
    }

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
}
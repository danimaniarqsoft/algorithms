package com.github.danimaniarqsoft.challenges.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.list.ListNode;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

class RemoveKthNodeTest {

    private final RemoveKthNodeChallenge solution = new RemoveKthNodeChallenge();

    @ParameterizedTest(name = "{3} (k={1})")
    @CsvFileSource(resources = "/remove-kth-node.csv", numLinesToSkip = 1)
    @DisplayName("Remove Kth Last Node Tests")
    void testRemoveKthNode(
            @ConvertWith(StringArrayConverter.class) int[] inputArr,
            int k,
            @ConvertWith(StringArrayConverter.class) int[] expectedArr,
            String description) {

        // 1. Arrange
        ListNode head = buildList(inputArr);

        // 2. Act
        ListNode result = solution.removeKthFromEnd(head, k);

        // 3. Assert
        String actualResult = listToString(result);
        String expectedResult = arrayToString(expectedArr);

        assertEquals(expectedResult, actualResult, "Failed: " + description);
    }

    private ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.setNext(new ListNode(arr[i]));
            current = current.getNext();
        }
        return head;
    }

    private String listToString(ListNode head) {
        if (head == null) return "";
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.getVal()).append(head.getNext() != null ? "," : "");
            head = head.getNext();
        }
        return sb.toString();
    }

    private String arrayToString(int[] arr) {
        if (arr == null || arr.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(i < arr.length - 1 ? "," : "");
        }
        return sb.toString();
    }
}
package com.github.danimaniarqsoft.challenges.fastandslowpointers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.list.ListNode;
import com.github.danimaniarqsoft.utils.StringArrayConverter;
import java.util.ArrayList;
import java.util.List;

/**
 * Integration test suite for Linked List Cycle Detection.
 * * This test uses a CSV data source to define various list structures,
 * including linear lists, lists with internal loops, and self-looping nodes.
 * It validates multiple algorithmic implementations against the same data.
 */
class LinkedListLoopTest {

    private final LinkedListLoop solution = new LinkedListLoop();

    /**
     * Executes cycle detection tests using Parameterized testing.
     * * @param inputArr Flat array representation of the node values.
     * 
     * @param loopIndex   The zero-based index of the node that the tail points to.
     *                    If -1, the list is linear (no cycle).
     * @param expected    Expected boolean result (true if a cycle exists).
     * @param description Narrative description for test reporting.
     */
    @ParameterizedTest(name = "{3}")
    @CsvFileSource(resources = "/linked-list-loop.csv", numLinesToSkip = 1)
    @DisplayName("Cycle Detection Tests")
    void testHasCycle(
            @ConvertWith(StringArrayConverter.class) int[] inputArr,
            int loopIndex,
            boolean expected,
            String description) {

        // 1. ARRANGE: Construct the linked list and inject a cycle if loopIndex >= 0.
        ListNode head = buildLoopList(inputArr, loopIndex);

        // 2. ACT: Execute both implementations available in the solution class.
        boolean resultHash = solution.hasCycleWithHash(head);
        boolean resultFloyd = solution.hasCycleWithFloyds(head);

        // 3. ASSERT: Ensure both algorithms arrive at the correct truth value.
        assertEquals(expected, resultHash, "HashSet detection failed for: " + description);
        assertEquals(expected, resultFloyd, "Floyd's detection failed for: " + description);
    }

    /**
     * Helper factory method to generate a Linked List with a cycle.
     * * It uses an internal List to keep track of created node references,
     * allowing the tail node to be linked back to a previous node by index.
     * * @param arr Values for the nodes.
     * 
     * @param loopIndex The index of the node that the last node points to.
     * @return The head of the constructed linked list.
     */
    private ListNode buildLoopList(int[] arr, int loopIndex) {
        if (arr == null || arr.length == 0)
            return null;

        List<ListNode> nodes = new ArrayList<>();
        ListNode head = new ListNode(arr[0]);
        nodes.add(head);

        ListNode current = head;
        // Build the linear sequence
        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            nodes.add(newNode);
            current.setNext(newNode);
            current = newNode;
        }

        // 4. INJECT CYCLE: Physically point the tail's 'next' reference to an earlier
        // node.
        if (loopIndex >= 0 && loopIndex < nodes.size()) {
            current.setNext(nodes.get(loopIndex));
        }

        return head;
    }
}
package com.github.danimaniarqsoft.challenges.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Arrays;

/**
 * Test suite for the Search Insert Position challenge.
 * Pattern: Binary Search.
 */
class InsertionIndexTest {

    private final InsertionIndex solution = new InsertionIndex();

    @ParameterizedTest(name = "Case {index}: {3} (Target: {1})")
    @CsvFileSource(resources = "/insertion-index.csv", numLinesToSkip = 1)
    @DisplayName("Insertion Index Validation")
    void testSearchInsert(String inputArray, int target, int expected, String description) {

        // Convert CSV string to int array
        int[] nums = (inputArray == null || inputArray.isEmpty())
                ? new int[0]
                : Arrays.stream(inputArray.split(",")).mapToInt(Integer::parseInt).toArray();

        // Act
        int result = solution.searchInsertOptimized(nums, target);

        // Assert
        assertEquals(expected, result, "Failed for: " + description);
    }
}
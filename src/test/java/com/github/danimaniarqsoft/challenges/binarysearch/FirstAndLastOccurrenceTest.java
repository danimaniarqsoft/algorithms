package com.github.danimaniarqsoft.challenges.binarysearch;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Arrays;

/**
 * Test suite for Find First and Last Position of Element in Sorted Array.
 * Pattern: Binary Search (Left and Right bounds).
 */
class FirstAndLastOccurrenceTest {

    private final OccurrenceFinder solution = new OccurrenceFinder();

    @ParameterizedTest(name = "Case {index}: {3}")
    @CsvFileSource(resources = "/first-last-occurrence.csv", numLinesToSkip = 1)
    @DisplayName("First and Last Occurrence Validation")
    void testFindRange(String inputArray, int target, String expectedStr, String description) {
        
        // Prepare Input
        int[] nums = (inputArray == null || inputArray.isEmpty()) 
                     ? new int[0] 
                     : Arrays.stream(inputArray.split(",")).mapToInt(Integer::parseInt).toArray();

        // Prepare Expected
        int[] expected = Arrays.stream(expectedStr.split(",")).mapToInt(Integer::parseInt).toArray();

        // Act
        int[] result = solution.searchRange(nums, target);

        // Assert
        assertArrayEquals(expected, result, "Failed for: " + description);
    }
}
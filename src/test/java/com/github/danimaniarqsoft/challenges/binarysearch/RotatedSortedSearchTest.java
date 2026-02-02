package com.github.danimaniarqsoft.challenges.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Arrays;

/**
 * Test suite for Search in Rotated Sorted Array.
 * Pattern: Modified Binary Search.
 */
class RotatedSortedSearchTest {

    private final RotatedSearch solution = new RotatedSearch();

    @ParameterizedTest(name = "Case {index}: Target {1} in {3}")
    @CsvFileSource(resources = "/rotated-sorted-search.csv", numLinesToSkip = 1)
    @DisplayName("Rotated Sorted Search Validation")
    void testSearch(String inputArray, int target, int expected, String description) {
        
        int[] nums = (inputArray == null || inputArray.isEmpty()) 
                     ? new int[0] 
                     : Arrays.stream(inputArray.split(",")).mapToInt(Integer::parseInt).toArray();

        int result = solution.search(nums, target);

        assertEquals(expected, result, "Failed for: " + description);
    }
}
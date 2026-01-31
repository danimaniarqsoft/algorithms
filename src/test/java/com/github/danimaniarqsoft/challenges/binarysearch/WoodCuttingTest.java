package com.github.danimaniarqsoft.challenges.binarysearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Arrays;

/**
 * Test suite for the Wood Cutting (EKO) challenge.
 * Pattern: Binary Search on the result space.
 */
class WoodCuttingTest {

    private final WoodCutter solution = new WoodCutter();

    @ParameterizedTest(name = "Case {index}: k={1}")
    @CsvFileSource(resources = "/cutting-wood.csv", numLinesToSkip = 1)
    @DisplayName("Wood Cutting Height Validation")
    void testFindMaxHeight(String heightsStr, int k, int expectedH, String description) {
        
        // Convert CSV string to int array
        int[] heights = Arrays.stream(heightsStr.split(","))
                              .mapToInt(Integer::parseInt)
                              .toArray();

        // Act
        int result = solution.findMaxHeight(heights, k);

        // Assert
        assertEquals(expectedH, result, "Failed for: " + description);
    }
}
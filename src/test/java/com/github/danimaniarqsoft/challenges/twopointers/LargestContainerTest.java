package com.github.danimaniarqsoft.challenges.twopointers;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Unit tests for the LargestContainer challenge.
 * This class uses a data-driven approach to test the "Container With Most
 * Water" algorithm.
 * It leverages JUnit 5 parameterized tests to run multiple scenarios defined in
 * a CSV file.
 */
public class LargestContainerTest {

    /**
     * Executes the largest container calculation for each record in the CSV file.
     * * @param input The array of heights, converted from a CSV string (e.g.,
     * "1,8,6")
     * to an int[] via the StringArrayConverter.
     * 
     * @param expected The expected maximum area for the given set of heights.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/largest-container.csv", numLinesToSkip = 1)
    void largestContainerTest(
            @ConvertWith(StringArrayConverter.class) int[] input,
            int expected) {

        // 1. ACT: Instantiate the solution class and calculate the result.
        // The algorithm typically uses a Two-Pointer approach for O(n) efficiency.
        int result = new LargestContainer().maxArea(input);

        // 2. ASSERT: Verify that the calculated maximum area matches the expected
        // value.
        assertEquals(expected, result);
    }
}
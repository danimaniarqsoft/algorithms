package com.github.danimaniarqsoft.challenges.twopointers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.utils.StringArrayConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Unit tests for the PairSumSorted class, which finds a pair of numbers
 * in a sorted array that sums up to a target value.
 * * This class uses JUnit 5 Parameterized Tests to run multiple test cases
 * sourced from an external CSV file.
 */
public class PairSumSortedTest {

    // Instance of the class containing the solution logic (Two Sum for Sorted
    // Array).
    private final PairSumSorted solution = new PairSumSorted();

    /**
     * Executes parameterized tests sourced from a CSV file.
     * * The test method leverages JUnit 5 features for clean data injection:
     * 1. @ParameterizedTest: Marks the method to be run multiple times with
     * different arguments.
     * 2. @CsvFileSource: Specifies the source of the test data (the CSV file).
     * 3. @ConvertWith: Uses a custom converter to transform CSV string data into
     * Java int arrays.
     * * @param input The sorted array of numbers (nums) read from the CSV,
     * converted by StringArrayConverter.
     * 
     * @param target   The integer target sum read from the CSV.
     * @param expected The expected indices array read from the CSV, converted by
     *                 StringArrayConverter.
     */
    @ParameterizedTest(name = "Nums: {0}, Target: {1} -> Expected: {2}")
    @CsvFileSource(resources = "/sum-sorted.csv", numLinesToSkip = 1)
    @DisplayName("Tests for the findTwoSum function with various scenarios")
    void testFindTwoSum(@ConvertWith(StringArrayConverter.class) int[] input, int target,
            @ConvertWith(StringArrayConverter.class) int[] expected) {

        // ACT: Call the solution method with the parsed input and target.
        int[] result = solution.findPair(input, target);

        // ASSERT: Verify that the actual result (the indices found) matches the
        // expected indices.
        // NOTE: If the problem allows different index orders (e.g., [2, 3] or [3, 2]),
        // the assertArrayEquals relies on the solution method or the expected array
        // being sorted/normalized.
        // If the problem states the order doesn't matter, ensure both 'result' and
        // 'expected' are sorted
        // before comparison, or handle the assertion within the test helper utility.
        assertArrayEquals(expected, result,
                "The returned indices did not match the expected indices for the target sum.");
    }
}
package com.github.danimaniarqsoft.challenges.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.utils.StringArrayConverter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

/**
 * Unit test for the PairSumUnsorted algorithm.
 * This class uses Data-Driven Testing (DDT) to evaluate various numerical
 * scenarios
 * provided by an external CSV file.
 */
public class PairSumUnsortedTest {

    // Instantiate the solution class once for all tests in this suite.
    private final PairSumUnsorted solution = new PairSumUnsorted();

    /**
     * Executes the Pair Sum logic and asserts that the returned indices are
     * correct.
     * * @param input The unsorted integer array, converted from CSV text to int[]
     * via StringArrayConverter.
     * 
     * @param target   The sum goal for any two numbers in the input array.
     * @param expected The correct indices that should be found, converted from CSV
     *                 text to int[].
     */
    @ParameterizedTest(name = "Nums: {0}, Target: {1} -> Expected: {2}")
    @CsvFileSource(resources = "/sum-unsorted.csv", numLinesToSkip = 1)
    @DisplayName("Tests for the findTwoSum function with various scenarios")
    void testFindTwoSum(
            @ConvertWith(StringArrayConverter.class) int[] input,
            int target,
            @ConvertWith(StringArrayConverter.class) int[] expected) {

        // 1. ACT: Call the algorithm to find the indices.
        int[] result = solution.solution(input, target);

        // 2. NORMALIZE: Since the problem allows indices in any order, we sort
        // both arrays to ensure a consistent comparison.
        // Example: [2, 0] becomes [0, 2], allowing it to match an expected [0, 2].
        Arrays.sort(result);
        Arrays.sort(expected);

        // 3. ASSERT: Compare the sorted actual result against the sorted expected
        // result.
        assertArrayEquals(expected, result,
                "The returned indices did not match the expected indices for the target sum.");
    }
}
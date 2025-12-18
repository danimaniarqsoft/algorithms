package com.github.danimaniarqsoft.arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.utils.ArrayPrint;
import com.github.danimaniarqsoft.utils.ListOfArrayConverter;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Unit tests for the TwoSum challenge.
 * This class uses JUnit 5 Parameterized Tests to verify that the TwoSum
 * implementation
 * correctly identifies the indices or values required to meet a target sum.
 */
class TwoSumTest {

    /**
     * Executes the Two Sum logic for various scenarios defined in an external CSV.
     * * @param input The array of integers, converted from the CSV using
     * StringArrayConverter.
     * 
     * @param target   The integer value that two numbers in the input array must
     *                 sum to.
     * @param expected The expected result array (e.g., indices [0, 1]), also
     *                 converted from the CSV.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/sum.csv", numLinesToSkip = 1)
    void twoSum(
            @ConvertWith(StringArrayConverter.class) int[] input,
            int target,
            @ConvertWith(ListOfArrayConverter.class) List<int[]> expected) {

        List<int[]> results = new TwoSum().process(input, target);

        for (int[] result : results) {
            Arrays.sort(result);
        }

        for (int[] pairExpected : expected) {
            Arrays.sort(pairExpected);
        }

        for (int[] pairExpected : expected) {
            int count = 0;
            for (int[] result : results) {
                if (Arrays.equals(pairExpected, result)) {
                    count++;
                }
            }

            assertEquals(expected.size(), count);
        }

    }
}

package com.github.danimaniarqsoft.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.hashtables.FirstRecurringCharacter;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Test suite for the FirstRecurringCharacter challenge.
 * * This class demonstrates a robust data-driven approach using JUnit 5:
 * 1. Parameterized testing to run multiple scenarios.
 * 2. External CSV data sourcing for better test management.
 * 3. Custom argument conversion to handle complex types like integer arrays.
 */
class FirstRecurringCharacterTest {

    /**
     * Executes the recurring character detection logic for each dataset provided in
     * the CSV.
     * * @param input An array of integers converted from a comma-separated string
     * in the CSV
     * using the StringArrayConverter.
     * 
     * @param expected The expected first recurring character (integer).
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/firstRecurring.csv", numLinesToSkip = 1)
    void firstRecurring(
            @ConvertWith(StringArrayConverter.class) int[] input,
            int expected) {

        // 1. ACT: Instantiate the logic class and process the input array.
        // Usually, this logic uses a HashSet to track seen elements with O(n) time
        // complexity.
        int result = new FirstRecurringCharacter().process(input);

        // 2. ASSERT: Check if the character identified matches the expected outcome
        // from the CSV.
        assertEquals(expected, result);
    }
}

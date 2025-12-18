package com.github.danimaniarqsoft.challenges;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.challenges.IsPalindromeValid;

/**
 * Test suite for the IsPalindromeValid challenge.
 * This class uses JUnit 5 Parameterized Tests to validate multiple strings
 * against expected palindrome results stored in an external CSV file.
 */
public class IsPalindromeValidTest {

    /**
     * Executes the palindrome validation logic for each row in the CSV file.
     * * @param input The string to be checked (mapped from the first column of the
     * CSV).
     * 
     * @param expected The expected boolean result (mapped from the second column of
     *                 the CSV).
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/IsPalindromeValid.csv", numLinesToSkip = 1)
    void isPalindromeValidTest(String input, boolean expected) {

        // 1. Arrange & Act: Instantiate the solution class and execute the algorithm.
        // Note: Creating a new instance per test ensures complete isolation.
        boolean result = new IsPalindromeValid().solution(input);

        // 2. Assert: Verify if the calculated result matches the expected output from
        // the CSV.
        assertEquals(expected, result);
    }
}
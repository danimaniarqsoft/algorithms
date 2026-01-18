package com.github.danimaniarqsoft.challenges.slidingwindows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for the Substring Anagrams challenge.
 * Validates the count of substrings in 's' that are anagrams of 't'.
 */
class SubstringAnagramsTest {

    private final SubstringAnagrams solution = new SubstringAnagrams();

    @ParameterizedTest(name = "Case {index}: {3}")
    @CsvFileSource(resources = "/substring-anagrams.csv", numLinesToSkip = 1)
    @DisplayName("Sliding Window Anagram Tests")
    void testCountAnagrams(String s, String t, int expected, String description) {
        
        // Act
        int result = solution.countAnagrams(s, t);

        // Assert
        assertEquals(expected, result, "Failed for scenario: " + description);
    }
}
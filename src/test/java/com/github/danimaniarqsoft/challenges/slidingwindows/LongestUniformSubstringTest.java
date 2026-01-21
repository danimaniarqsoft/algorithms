package com.github.danimaniarqsoft.challenges.slidingwindows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for the Longest Uniform Substring challenge.
 * Pattern: Sliding Window with character frequency tracking.
 */
class LongestUniformSubstringTest {

    private final LongestUniformSubstring solution = new LongestUniformSubstring();

    @ParameterizedTest(name = "Case {index}: {3}")
    @CsvFileSource(resources = "/longest-uniform-substring.csv", numLinesToSkip = 1)
    @DisplayName("Uniform Substring Replacements Validation")
    void testLongestUniformSubstring(String input, int k, int expected, String description) {
        
        // Handle empty CSV strings
        String s = (input == null) ? "" : input;

        // Act
        int result = solution.characterReplacement(s, k);

        // Assert
        assertEquals(expected, result, "Failed for: " + description);
    }
}
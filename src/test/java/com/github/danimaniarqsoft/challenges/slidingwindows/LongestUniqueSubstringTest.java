package com.github.danimaniarqsoft.challenges.slidingwindows;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for the Longest Substring with Unique Characters challenge.
 * Uses a dynamic sliding window to find the max length.
 */
class LongestUniqueSubstringTest {

    private final LongestUniqueSubstring solution = new LongestUniqueSubstring();

    @ParameterizedTest(name = "Case {index}: {2} (Input: {0})")
    @CsvFileSource(resources = "/longest-unique-substring.csv", numLinesToSkip = 1)
    @DisplayName("Unique Substring Validation")
    void testLongestSubstring(String input, int expected, String description) {

        // Handle CSV null representation if necessary
        String s = (input == null) ? "" : input;

        // Act
        int resultWithSet = solution.lengthOfLongestSubstringWithSet(s);
        int resultOptimized = solution.lengthOfLongestSubstringOptimized(s);
        int resultAscii = solution.lengthOfLongestSubstringOptimizedAscii(s);
        // Assert
        assertEquals(expected, resultWithSet, "Failed for (With set): " + description);
        assertEquals(expected, resultOptimized, "Failed for (Optimized): " + description);
        assertEquals(expected, resultAscii, "Failed for (Optimized): " + description);
    }
}
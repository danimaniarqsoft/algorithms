package com.github.danimaniarqsoft.challenges.fastandslowpointers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for Happy Number detection.
 * Validates if a number eventually reaches 1 or gets stuck in a loop.
 */
class HappyNumberTest {

    private final HappyNumber solution = new HappyNumber();

    @ParameterizedTest(name = "Input: {0} | Expected: {1}")
    @CsvFileSource(resources = "/happy-number.csv", numLinesToSkip = 1)
    @DisplayName("Happy Number Tests")
    void testIsHappy(int input, boolean expected, String description) {
        
        // Act
        boolean result = solution.isHappy(input);

        // Assert
        assertEquals(expected, result, "Failed for: " + description);
    }
}
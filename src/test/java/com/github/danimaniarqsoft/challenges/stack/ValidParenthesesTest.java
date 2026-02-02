package com.github.danimaniarqsoft.challenges.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for Valid Parentheses challenge.
 * Pattern: Stack Data Structure.
 */
class ValidParenthesesTest {

    private final ParenthesesValidator validator = new ParenthesesValidator();

    @ParameterizedTest(name = "Case {index}: {0} -> {1}")
    @CsvFileSource(resources = "/valid-parentheses.csv", numLinesToSkip = 1)
    @DisplayName("Parentheses Validation")
    void testIsValid(String input, boolean expected, String description) {
        // Handle null/empty string from CSV if necessary
        String s = (input == null) ? "" : input;
        
        boolean result = validator.isValid(s);

        assertEquals(expected, result, "Failed for: " + description);
    }
}
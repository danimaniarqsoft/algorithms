package com.github.danimaniarqsoft.challenges.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for the Evaluate Expression challenge.
 * Pattern: Stack-based arithmetic parsing.
 */
class ExpressionEvaluatorTest {

    private final ExpressionEvaluator evaluator = new ExpressionEvaluator();

    @ParameterizedTest(name = "Case {index}: {0} = {1}")
    @CsvFileSource(resources = "/evaluate-expression.csv", numLinesToSkip = 1)
    @DisplayName("Mathematical Expression Validation")
    void testEvaluate(String input, int expected, String description) {
        
        int result = evaluator.calculate(input);

        assertEquals(expected, result, "Failed for: " + description);
    }
}
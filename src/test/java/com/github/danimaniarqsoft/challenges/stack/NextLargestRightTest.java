package com.github.danimaniarqsoft.challenges.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Arrays;

/**
 * Test suite for Next Largest Number to the Right.
 * Pattern: Monotonic Stack.
 */
class NextLargestRightTest {

    private final NextLargestFinder finder = new NextLargestFinder();

    @ParameterizedTest(name = "Case {index}: {3}")
    @CsvFileSource(resources = "/next-largest-right.csv", numLinesToSkip = 1)
    @DisplayName("Next Largest Right Validation")
    void testNextLargest(String inputArray, String expectedOutput, String description) {
        
        int[] nums = (inputArray == null || inputArray.isEmpty()) 
                     ? new int[0] 
                     : Arrays.stream(inputArray.split(",")).mapToInt(Integer::parseInt).toArray();

        int[] expected = (expectedOutput == null || expectedOutput.trim().isEmpty())
                     ? new int[0]
                     : Arrays.stream(expectedOutput.split(",")).mapToInt(Integer::parseInt).toArray();

        int[] result = finder.nextGreaterElement(nums);

        assertArrayEquals(expected, result, "Failed for: " + description);
    }
}
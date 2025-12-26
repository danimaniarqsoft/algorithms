package com.github.danimaniarqsoft.challenges.hashmaps;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.challenges.hashmaps.zerostriping.ZeroStriping;
import com.github.danimaniarqsoft.challenges.hashmaps.zerostriping.ZeroStripingOptimized;
import com.github.danimaniarqsoft.challenges.hashmaps.zerostriping.ZeroStripingWithBooleanMarker;
import com.github.danimaniarqsoft.challenges.hashmaps.zerostriping.ZeroStripingWithHashmap;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

/**
 * Integration test suite for Zero Striping implementations.
 * This class validates that all algorithm variations (HashMap, Boolean Marker,
 * and Optimized)
 * satisfy the same business requirements defined in the CSV dataset.
 */
class ZeroStripingTest {

    /**
     * Executes the zero-striping logic across multiple implementations for each CSV
     * row.
     * * @param rows Number of rows in the matrix.
     * 
     * @param cols         Number of columns in the matrix.
     * @param flatInput    The 1D array from CSV representing the initial matrix
     *                     state.
     * @param flatExpected The 1D array from CSV representing the expected final
     *                     state.
     * @param description  Human-readable description of the test scenario.
     */
    @ParameterizedTest(name = "{4} ({0}x{1})")
    @CsvFileSource(resources = "/zero-striping.csv", numLinesToSkip = 1)
    @DisplayName("Zero Striping Matrix Tests")
    void testZeroStriping(
            int rows,
            int cols,
            @ConvertWith(StringArrayConverter.class) int[] flatInput,
            @ConvertWith(StringArrayConverter.class) int[] flatExpected,
            String description) {

        // Define the "Strategies" to be tested.
        // All these classes must implement the ZeroStriping interface.
        List<ZeroStriping> implementations = List.of(
                new ZeroStripingWithHashmap(),
                new ZeroStripingOptimized(),
                new ZeroStripingWithBooleanMarker());

        for (ZeroStriping implementation : implementations) {

            // 1. ARRANGE: Reconstruct 2D matrices from flat CSV data for each
            // implementation.
            // We reconstruct inside the loop because the algorithm modifies the matrix
            // "in-place".
            int[][] matrix = reconstructMatrix(rows, cols, flatInput);
            int[][] expected = reconstructMatrix(rows, cols, flatExpected);

            // 2. ACT: Process the matrix using the current implementation strategy.
            implementation.solution(matrix);

            // 3. ASSERT: Verify the in-place modifications match the expected output.
            assertArrayEquals(expected, matrix,
                    String.format("[%s] failed for scenario: %s",
                            implementation.getClass().getSimpleName(), description));
        }
    }

    /**
     * Utility method to map a flat 1D array into a 2D matrix structure.
     * Uses row-major order: index / cols for row, index % cols for column.
     */
    private int[][] reconstructMatrix(int rows, int cols, int[] flat) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < flat.length; i++) {
            matrix[i / cols][i % cols] = flat[i];
        }
        return matrix;
    }
}
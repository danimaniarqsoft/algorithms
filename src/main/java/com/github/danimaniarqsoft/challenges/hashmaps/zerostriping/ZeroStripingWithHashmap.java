package com.github.danimaniarqsoft.challenges.hashmaps.zerostriping;

import java.util.HashSet;

/**
 * Solution for the Zero Striping challenge.
 * This implementation uses the "Record and Apply" strategy to ensure that
 * only original zeros trigger the row/column clearing.
 * * Time Complexity: O(M * N) - Where M is rows and N is columns.
 * Space Complexity: O(M + N) - In the worst case, we store indices for all rows
 * and columns.
 */
public class ZeroStripingWithHashmap implements ZeroStriping {

    /**
     * Processes the matrix to set rows and columns to zero if a zero is found.
     * * @param matrix The M x N integer matrix to process.
     * 
     * @return The modified matrix (processed in-place).
     */
    public int[][] solution(int[][] matrix) {
        // Defensive check for empty or null input
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        // Sets to track which row/column indices contain at least one zero.
        HashSet<Integer> rowsToZero = new HashSet<>();
        HashSet<Integer> colsToZero = new HashSet<>();

        // 1. FIRST PASS: Scrutinize every cell to find original zeros.
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
                if (matrix[rowIndex][colIndex] == 0) {
                    rowsToZero.add(rowIndex);
                    colsToZero.add(colIndex);
                }
            }
        }

        // 2. SECOND PASS: Update the matrix based on the indices recorded.
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
                // If the current row OR current column was marked, set cell to 0.
                if (rowsToZero.contains(rowIndex) || colsToZero.contains(colIndex)) {
                    matrix[rowIndex][colIndex] = 0;
                }
            }
        }

        return matrix;
    }
}
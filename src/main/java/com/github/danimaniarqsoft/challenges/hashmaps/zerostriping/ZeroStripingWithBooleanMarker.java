package com.github.danimaniarqsoft.challenges.hashmaps.zerostriping;

/**
 * Implements the Zero Striping algorithm.
 * If an element in an MxN matrix is 0, its entire row and column are set to 0.
 * * Time Complexity: O(M * N) - We visit every cell twice.
 * Space Complexity: O(M + N) - We store markers for rows and columns.
 */
public class ZeroStripingWithBooleanMarker implements ZeroStriping {

    public int[][] solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int rowsCount = matrix.length;
        int colsCount = matrix[0].length;

        // 1. Use boolean arrays instead of HashSets.
        // This avoids object overhead and auto-boxing.
        boolean[] rowMarkers = new boolean[rowsCount];
        boolean[] colMarkers = new boolean[colsCount];

        // 2. First Pass: Record the positions of all zeros.
        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < colsCount; c++) {
                if (matrix[r][c] == 0) {
                    rowMarkers[r] = true;
                    colMarkers[c] = true;
                }
            }
        }

        // 3. Second Pass: Set the entire row or column to zero based on markers.
        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < colsCount; c++) {
                if (rowMarkers[r] || colMarkers[c]) {
                    matrix[r][c] = 0;
                }
            }
        }

        return matrix;
    }
}
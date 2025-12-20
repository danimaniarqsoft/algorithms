package com.github.danimaniarqsoft.challenges.hashmaps;

/**
 * Validates if a 9x9 Sudoku board is valid.
 * Optimized for O(1) space complexity (fixed size) and O(1) time (81 cells).
 */
public class VerifySudokuBoard {

    private static final int BOARD_SIZE = 9;

    public boolean solution(int[][] input) {
        // 1. Basic integrity check
        if (input == null || input.length != BOARD_SIZE) {
            return false;
        }

        // 2. Use boolean arrays instead of Sets
        // This drastically reduces object creation and auto-boxing/unboxing.
        // Size 10 is used so we can use the value (1-9) directly as an index.
        boolean[][] rows = new boolean[BOARD_SIZE][BOARD_SIZE + 1];
        boolean[][] cols = new boolean[BOARD_SIZE][BOARD_SIZE + 1];
        boolean[][] boxes = new boolean[BOARD_SIZE][BOARD_SIZE + 1];

        for (int r = 0; r < BOARD_SIZE; r++) {
            // Check for malformed rows (ragged arrays)
            if (input[r] == null || input[r].length != BOARD_SIZE) {
                return false;
            }

            for (int c = 0; c < BOARD_SIZE; c++) {
                int val = input[r][c];

                // Skip empty cells (0)
                if (val == 0) {
                    continue;
                }

                // Range validation (good practice even if constraints suggest 0-9)
                if (val < 1 || val > 9) {
                    return false;
                }

                // 3. Mathematical Sub-grid Indexing
                // This formula maps the 9x9 grid into 9 sub-boxes (indexed 0-8)
                int boxIndex = (r / 3) * 3 + (c / 3);

                // 4. Duplicate Check
                // If the value already exists in the row, column, or box, return false.
                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                // Mark the value as seen
                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;
            }
        }

        return true;
    }
}
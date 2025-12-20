package com.github.danimaniarqsoft.challenges.hashmaps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.utils.StringArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Validates the Sudoku Board verification logic using various board
 * configurations.
 */
@DisplayName("Sudoku Board Validator Tests")
public class VerifySudokuBoardTest {

    private final VerifySudokuBoard validator = new VerifySudokuBoard();
    private static final int BOARD_SIZE = 9;

    @ParameterizedTest(name = "Test Case {index}: Expected Validity = {1}")
    @CsvFileSource(resources = "/verify-sudoku-board.csv", numLinesToSkip = 1)
    @DisplayName("Check if the Sudoku board state follows row, column, and sub-grid rules")
    void testVerifySudokuBoard(
            @ConvertWith(StringArrayConverter.class) int[] flatBoard,
            boolean expected) {

        int[][] board = convertToMatrix(flatBoard);
        boolean actual = validator.solution(board);

        assertEquals(expected, actual,
                String.format("Sudoku validation failed for the provided board state. Expected: %b", expected));
    }

    /**
     * Converts a 1D array of 81 integers into a 2D 9x9 matrix.
     * Uses simple math (index / size) and (index % size) for clarity.
     */
    private int[][] convertToMatrix(int[] flatBoard) {
        if (flatBoard == null || flatBoard.length != (BOARD_SIZE * BOARD_SIZE)) {
            throw new IllegalArgumentException("Input array must contain exactly 81 elements.");
        }

        int[][] matrix = new int[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < flatBoard.length; i++) {
            matrix[i / BOARD_SIZE][i % BOARD_SIZE] = flatBoard[i];
        }
        return matrix;
    }
}
package com.github.danimaniarqsoft.challenges.hashmaps.zerostriping;

public class ZeroStripingOptimized implements ZeroStriping {

    public int[][] solution(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        boolean isFirsRowZeroes = false;
        boolean isFirstColZeroes = false;

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        for (int row = 0; row < rowCount; row++) {
            if (matrix[row][0] == 0) {
                isFirstColZeroes = true;
            }
        }

        for (int col = 0; col < colCount; col++) {
            if (matrix[0][col] == 0) {
                isFirsRowZeroes = true;
            }
        }

        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {
                if (matrix[row][col] == 0) {
                    matrix[0][col] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        for (int row = 1; row < rowCount; row++) {
            for (int col = 1; col < colCount; col++) {
                if (matrix[0][col] == 0 || matrix[row][0] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (isFirsRowZeroes) {
            for (int col = 0; col < colCount; col++) {
                matrix[0][col] = 0;
            }
        }

        if (isFirstColZeroes) {
            for (int row = 0; row < rowCount; row++) {
                matrix[row][0] = 0;

            }
        }

        return matrix;
    }

}

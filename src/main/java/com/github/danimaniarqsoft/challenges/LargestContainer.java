package com.github.danimaniarqsoft.challenges;

/**
 * Provides a solution for the Container With Most Water problem.
 * This implementation uses the Two-Pointer technique to find the maximum area
 * between two lines in an array of heights.
 */
public class LargestContainer {

    /**
     * Calculates the maximum area of water a container can hold.
     * * @param input An array where each element represents the height of a line at
     * that index.
     * 
     * @return The maximum area found; returns 0 if the input is null or has fewer
     *         than 2 lines.
     */
    public int solution(int[] input) {

        // 1. Edge Case: A container requires at least two lines.
        if (input == null || input.length < 2) {
            return 0;
        }

        // 2. Initialize Pointers: One at the start (left) and one at the end (right).
        int leftIndex = 0;
        int rightIndex = input.length - 1;

        int maxSize = 0;

        // 3. Iterate until pointers meet.
        while (leftIndex < rightIndex) {

            // Calculate the width (distance between the two lines).
            int base = rightIndex - leftIndex;

            // Calculate the current area:
            // The height of water is limited by the SHORTER of the two lines.
            int currenSize = Math.min(input[leftIndex], input[rightIndex]) * base;

            // Update the maximum size found so far.
            if (currenSize > maxSize) {
                maxSize = currenSize;
            }

            // 4. Movement Logic:
            // To find a potentially larger area, we must move the pointer
            // pointing to the SHORTER line, as the shorter line is the limiting factor.
            if (input[leftIndex] < input[rightIndex]) {
                leftIndex++;
            } else if (input[leftIndex] > input[rightIndex]) {
                rightIndex--;
            } else {
                // If heights are equal, moving both is a valid optimization
                // because moving just one wouldn't increase the area unless
                // the next line is significantly taller.
                leftIndex++;
                rightIndex--;
            }
        }

        return maxSize;
    }
}
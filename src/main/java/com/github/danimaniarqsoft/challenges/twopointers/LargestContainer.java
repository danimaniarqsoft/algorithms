package com.github.danimaniarqsoft.challenges.twopointers;

/**
 * Challenge: Find two lines that form a container that holds the most water.
 * Pattern: Two Pointers (Greedy Convergence).
 * * Performance:
 * - Time Complexity: O(n) - Single pass through the array.
 * - Space Complexity: O(1) - Constant extra space.
 */
public class LargestContainer {

    /**
     * Calculates the maximum area of water a container can hold.
     * * @param heights An array where each element represents the height of a line.
     * 
     * @return The maximum area found.
     */
    public int maxArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int currentHeight = Math.min(heights[left], heights[right]);

            // Equation: $$Area = \text{width} \times \min(h_{left}, h_{right})$$
            maxArea = Math.max(maxArea, width * currentHeight);

            // Movement Logic with Equality Optimization:
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                // OPTIMIZATION: When heights are equal, moving just one side
                // cannot increase the area. We move both to save iterations.
                left++;
                right--;
            }
        }

        return maxArea;
    }
}
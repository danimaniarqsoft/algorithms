package com.github.danimaniarqsoft.challenges.binarysearch;

/**
 * Challenge: Find the insertion index of a target in a sorted array.
 * This class demonstrates the transition from O(n) to O(log n) efficiency.
 */
public class InsertionIndex {

    /**
     * Linear Search Approach.
     * Iterates through the array until it finds a value >= target.
     * * Time Complexity: O(n) - Linear scan.
     * Space Complexity: O(1) - Constant space.
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            // Since array is sorted, the first element >= target is the insertion point
            if (nums[i] >= target) {
                return i;
            }
        }

        // Target is greater than all elements
        return nums.length;
    }

    /**
     * Optimized Binary Search Approach.
     * Repeatedly divides the search space in half.
     * * Time Complexity: O(log n) - Logarithmic search.
     * Space Complexity: O(1) - Constant space.
     */
    public int searchInsertOptimized(int[] nums, int target) {
        // Note: Used '||' for short-circuit evaluation
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length; // Uses the exclusive boundary logic

        while (left < right) {
            // Refined calculation to prevent (left + right) overflow
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            }

            if (nums[middle] > target) {
                // Target is in the left half, move right boundary
                right = middle;
            } else {
                // Target is in the right half, move left boundary
                left = middle + 1;
            }
        }

        // When the loop ends, left == right, which is the insertion index
        return left;
    }
}
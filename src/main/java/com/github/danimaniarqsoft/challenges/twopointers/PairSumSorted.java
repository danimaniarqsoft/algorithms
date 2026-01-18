package com.github.danimaniarqsoft.challenges.twopointers;

/**
 * Challenge: Find two indices in a sorted array that sum to a target value.
 * Pattern: Two Pointers (Converging).
 * * Performance:
 * - Time Complexity: O(n) where n is the length of the array.
 * - Space Complexity: O(1) as we only use two pointers regardless of array
 * size.
 */
public class PairSumSorted {

    /**
     * Finds the indices of two numbers that add up to the target.
     * 
     * @param nums   The sorted array of integers.
     * 
     * @param target The desired sum.
     * @return An array containing the two indices, or an empty array if no pair
     *         exists.
     */
    public int[] findPair(int[] nums, int target) {
        // Guard clause: A pair requires at least two elements
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Optional: Handle potential overflow by using a long for the sum
            // if the array values are near Integer.MAX_VALUE.
            int currentSum = nums[left] + nums[right];

            if (currentSum == target) {
                return new int[] { left, right };
            } else if (currentSum > target) {
                // Sum is too high; move the right pointer left to find a smaller number.
                right--;
            } else {
                // Sum is too low; move the left pointer right to find a larger number.
                left++;
            }
        }

        // Return empty array if the pointers cross without finding the target.
        return new int[0];
    }
}
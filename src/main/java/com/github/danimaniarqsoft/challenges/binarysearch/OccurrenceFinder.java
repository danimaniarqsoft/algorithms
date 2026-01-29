package com.github.danimaniarqsoft.challenges.binarysearch;

/**
 * Challenge: Find First and Last Position of Element in Sorted Array.
 * Pattern: Modified Binary Search.
 * * Performance:
 * - Time Complexity: O(log n) - Two binary searches are performed.
 * - Space Complexity: O(1) - Constant space used.
 */
public class OccurrenceFinder {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int firstIndex = findBound(nums, target, true);
        
        // If the first occurrence doesn't exist, the target isn't in the array
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }

        int lastIndex = findBound(nums, target, false);

        return new int[]{firstIndex, lastIndex};
    }

    /**
     * Helper method to find either the leftmost or rightmost occurrence.
     * * @param isFirst If true, seeks the first occurrence; otherwise, the last.
     */
    private int findBound(int[] nums, int target, boolean isFirst) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid; // Potential answer found, but keep looking!
                if (isFirst) {
                    high = mid - 1; // Look for earlier occurrences in the left half
                } else {
                    low = mid + 1;  // Look for later occurrences in the right half
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
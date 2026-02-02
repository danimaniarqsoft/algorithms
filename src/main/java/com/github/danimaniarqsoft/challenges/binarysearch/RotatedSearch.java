package com.github.danimaniarqsoft.challenges.binarysearch;

/**
 * Challenge: Search in a Rotated Sorted Array.
 * Pattern: Modified Binary Search.
 * * This algorithm finds a target value in O(log n) time by identifying which 
 * half of the array is sorted and determining if the target lies within it.
 */
public class RotatedSearch {

    /**
     * Searches for the target in a rotated sorted array.
     * * @param nums   The rotated sorted array of unique integers.
     * @param target The value to find.
     * @return The index of the target if found, otherwise -1.
     */
    public int search(int[] nums, int target) {
        // Optimization: Use logical OR (||) for short-circuit evaluation
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // STEP 1: Identify which side is sorted
            if (nums[left] <= nums[mid]) { 
                // The LEFT side is sorted
                
                // STEP 2: Check if target is within the sorted range
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Target is in the left sorted part
                } else {
                    left = mid + 1;  // Target must be in the right part
                }
            } else { 
                // The RIGHT side is sorted
                
                // STEP 2: Check if target is within the sorted range
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // Target is in the right sorted part
                } else {
                    right = mid - 1; // Target must be in the left part
                }
            }
        }

        return -1; // Target not found
    }
}
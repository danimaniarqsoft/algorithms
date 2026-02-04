package com.github.danimaniarqsoft.challenges.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Challenge: Next Largest Number to the Right.
 * Pattern: Monotonic Decreasing Stack.
 * * Performance Analysis:
 * - Time Complexity: O(n)
 * Each element is pushed onto the stack exactly once and popped at most once.
 * The while loop executes at most 'n' times across the entire runtime.
 * * - Space Complexity: O(n)
 * In the worst case (e.g., a strictly decreasing array), the stack will
 * store all 'n' indices.
 */
public class NextLargestFinder {

    /**
     * Finds the first greater element to the right for every element in the array.
     * * @param nums The input array of integers.
     * 
     * @return An array where each element is the next larger value or -1 if none
     *         exists.
     */
    public int[] nextGreaterElement(int[] nums) {
        // Handle empty or null edge cases
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];

        // Initialize result with -1: O(n) time
        Arrays.fill(result, -1);

        // Deque is preferred over the legacy Stack class for performance
        // This stack stores indices of elements waiting for a "larger neighbor"
        Deque<Integer> stack = new ArrayDeque<>();

        // Main traversal: O(n) time
        for (int i = 0; i < n; i++) {
            /*
             * While the current number is greater than the number at the top
             * of our 'waiting' stack, we update those indices.
             */
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int indexToUpdate = stack.pop();
                result[indexToUpdate] = nums[i];
            }

            // Push current index to find its next larger element later
            stack.push(i);
        }

        return result;
    }
}
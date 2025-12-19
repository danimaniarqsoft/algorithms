package com.github.danimaniarqsoft.challenges.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implements the solution for the "3SUM" challenge: finding all unique triplets
 * [a, b, c] in an array that sum up to zero (a + b + c = 0).
 * * The solution utilizes the Sorting and Two-Pointer technique for an optimal
 * time complexity of O(n^2), which is significantly better than a naive O(n^3)
 * approach.
 */
public class TripletSum {

    /**
     * Finds all unique triplets in the input array that sum to zero.
     * * The core idea is to fix the first element (a) and then use a modified
     * Two-Pointer method on the rest of the array to find the remaining pair (b, c)
     * such that b + c = -a.
     * * @param input The array of integers.
     * 
     * @return A List of int arrays, where each array is a unique triplet [a, b, c]
     *         summing to zero.
     */
    public List<int[]> solution(int[] input) {

        // 1. Handle Edge Case: If the array is null or has fewer than 3 elements,
        // no triplet can be formed.
        if (input == null || input.length < 3) {
            return new ArrayList<>();
        }

        // 2. Sort the Array: Sorting is MANDATORY for two reasons:
        // a) Enables the two-pointer technique to work efficiently.
        // b) Simplifies the process of skipping duplicate elements.
        Arrays.sort(input);
        List<int[]> triplets = new ArrayList<>();

        // 3. Outer Loop (Fix the First Element 'a'):
        // We only need to iterate up to input.length - 2 because we need at least
        // two elements (b and c) remaining after the current index.
        for (int leftIndex = 0; leftIndex < input.length - 2; leftIndex++) {

            // Duplicate Check for 'a': Skip the current element if it is the same
            // as the previous element to avoid duplicate triplets.
            if (leftIndex > 0 && input[leftIndex] == input[leftIndex - 1]) {
                continue;
            }

            int firstValue = input[leftIndex];

            // 4. Two-Sum Sub-Problem:
            // We now search for two numbers (b and c) that sum up to -(firstValue).
            int targetForTwoSum = firstValue * -1;

            // Start the two-pointer search immediately after the fixed element.
            List<int[]> pairs = findPairs(input, leftIndex + 1, targetForTwoSum);

            // 5. Accumulate Results: Combine the fixed element 'a' with the found pairs (b,
            // c).
            if (!pairs.isEmpty()) {
                for (int[] pair : pairs) {
                    // Create the final triplet [a, b, c]
                    triplets.add(new int[] { firstValue, pair[0], pair[1] });
                }
            }
        }

        return triplets;
    }

    /**
     * Finds unique pairs in a sorted array slice that sum to a specific target.
     * This is a standard Two-Pointer implementation.
     * * @param input The sorted array.
     * 
     * @param leftIndex The starting index for the search (start of the slice).
     * @param target    The desired sum of the pair (b + c).
     * @return A List of int arrays, where each array is a unique pair [b, c].
     */
    private static List<int[]> findPairs(int[] input, int leftIndex, int target) {

        List<int[]> pairs = new ArrayList<>();

        // Edge case: ensure the slice has at least two elements to form a pair.
        if (input == null || input.length < 2) {
            return new ArrayList<>();
        }

        // Set the right pointer to the end of the array.
        int rightIndex = input.length - 1;

        // Loop as long as the pointers haven't crossed.
        while (leftIndex < rightIndex) {
            int sum = input[leftIndex] + input[rightIndex];

            if (sum > target) {
                // Sum is too high, move the right pointer left to decrease the sum.
                rightIndex--;
            } else if (sum < target) {
                // Sum is too low, move the left pointer right to increase the sum.
                leftIndex++;
            } else {
                // Sum == target: Pair found!
                pairs.add(new int[] { input[leftIndex], input[rightIndex] });

                // Move the left pointer to the next position.
                leftIndex++;

                // Duplicate Check for 'b': Skip all subsequent elements that are identical
                // to the one we just used to ensure unique triplets.
                while (leftIndex < rightIndex && input[leftIndex] == input[leftIndex - 1]) {
                    leftIndex++;
                }

                // Note: The right pointer doesn't need an explicit duplicate skip loop
                // because the outer logic will shift it if the next sum is still too large.
            }
        }

        return pairs;
    }
}
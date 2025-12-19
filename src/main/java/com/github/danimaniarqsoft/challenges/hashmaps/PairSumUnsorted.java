package com.github.danimaniarqsoft.challenges.hashmaps;

import java.util.HashMap;
import java.util.Map;

/**
 * Solves the Pair Sum problem for an unsorted array using a Hash Map.
 * Time Complexity: O(n) - We traverse the list containing n elements only once.
 * Space Complexity: O(n) - The extra space required depends on the number of
 * items stored in the hash table.
 */
public class PairSumUnsorted {

    public int[] solution(int[] input, int target) {
        // 1. Pre-condition check
        if (input == null || input.length < 2) {
            return new int[0];
        }

        // 2. Map stores: Key = Value from array, Value = Index of that value
        // Initializing capacity can slightly improve performance for large arrays
        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int currentNum = input[i];
            int complement = target - currentNum;

            // 3. Optimization: Call get() once and check for null
            // This is faster than calling containsKey() followed by get()
            Integer complementIndex = visitedNumbers.get(complement);

            if (complementIndex != null) {
                // Pair found! Return the stored index and current index
                return new int[] { complementIndex, i };
            }

            // 4. Store the current number and its index for future lookups
            visitedNumbers.put(currentNum, i);
        }

        // Return empty array if no pair is found
        return new int[0];
    }
}
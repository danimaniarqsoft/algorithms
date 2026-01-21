package com.github.danimaniarqsoft.challenges.slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * Challenge: Longest Repeating Character Replacement.
 * Find the longest substring of same characters achievable by replacing at most
 * 'k' characters.
 * * Pattern: Dynamic Sliding Window (Expand-Contract)
 * Time Complexity: O(N) - Each character is visited at most twice.
 * Space Complexity: O(1) - The map stores at most 26-52 characters (fixed
 * alphabet size).
 */
public class LongestUniformSubstring {

    /**
     * Calculates the maximum length of a uniform substring possible after k
     * replacements.
     * * @param inputString The source string to analyze.
     * 
     * @param maxReplacements (k) The maximum number of characters we can change.
     * @return The length of the longest uniform substring possible.
     */
    public int characterReplacement(String inputString, int maxReplacements) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        int maxCharFrequencyInWindow = 0;
        int maxResultLength = 0;
        int windowStart = 0;
        int windowEnd = 0;

        // Tracking frequency of characters within the current window
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        while (windowEnd < inputString.length()) {
            char rightChar = inputString.charAt(windowEnd);

            // Increment frequency for the incoming character
            int currentFrequency = charFrequencyMap.getOrDefault(rightChar, 0) + 1;
            charFrequencyMap.put(rightChar, currentFrequency);

            // The core of the greedy approach: track the most frequent character in the
            // current window
            maxCharFrequencyInWindow = Math.max(maxCharFrequencyInWindow, currentFrequency);

            /*
             * VALIDATION LOGIC:
             * windowSize = (windowEnd - windowStart + 1)
             * replacementsNeeded = windowSize - maxCharFrequencyInWindow
             * * If replacementsNeeded > k, the current window is invalid.
             * We slide the window by shrinking from the left.
             */
            int currentWindowSize = windowEnd - windowStart + 1;
            if (currentWindowSize - maxCharFrequencyInWindow > maxReplacements) {
                char leftChar = inputString.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                windowStart++;
            }

            // After potential shrinkage, calculate the valid window size
            maxResultLength = Math.max(maxResultLength, windowEnd - windowStart + 1);

            windowEnd++;
        }

        return maxResultLength;
    }
}
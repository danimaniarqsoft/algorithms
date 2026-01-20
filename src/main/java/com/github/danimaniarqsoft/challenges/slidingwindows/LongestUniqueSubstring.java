package com.github.danimaniarqsoft.challenges.slidingwindows;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Solutions for finding the length of the longest substring with unique
 * characters.
 * This class demonstrates three levels of optimization using the Sliding Window
 * pattern.
 */
public class LongestUniqueSubstring {

    /**
     * Finds the longest substring using a HashSet to track seen characters.
     * * Strategy: A "Slow-Shrink" sliding window. When a duplicate is found, the
     * window
     * shrinks from the left one character at a time until the duplicate is removed.
     * * Time Complexity: O(N) - Each character is visited at most twice (once by
     * each pointer).
     * Space Complexity: O(min(M, N)) - Where M is the size of the character set.
     */
    public int lengthOfLongestSubstringWithSet(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        char[] characters = text.toCharArray();
        int windowStart = 0;
        int windowEnd = 0;

        Set<Character> uniqueChars = new HashSet<>();

        while (windowEnd < characters.length) {
            if (uniqueChars.contains(characters[windowEnd])) {
                // Duplicate found: remove the character at the start and move the pointer
                uniqueChars.remove(characters[windowStart]);
                windowStart++;
            } else {
                // New character: add to set and expand the window
                uniqueChars.add(characters[windowEnd]);
                maxLength = Math.max(maxLength, (windowEnd - windowStart) + 1);
                windowEnd++;
            }
        }

        return maxLength;
    }

    /**
     * Finds the longest substring using a HashMap to store character positions.
     * * Strategy: A "Fast-Catchup" sliding window. Instead of shrinking slowly,
     * the window start "jumps" directly past the last seen index of the duplicate.
     * * Time Complexity: O(N) - Single pass through the string.
     * Space Complexity: O(min(M, N)) - HashMap stores character-index pairs.
     */
    public int lengthOfLongestSubstringOptimized(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        char[] characters = text.toCharArray();
        int maxLength = 0;
        int windowStart = 0;
        int windowEnd = 0;

        // Maps Character -> Last seen index
        Map<Character, Integer> lastSeenPositions = new HashMap<>();

        while (windowEnd < characters.length) {
            Integer lastSeenIndex = lastSeenPositions.get(characters[windowEnd]);

            // If the character is new OR its last occurrence is outside the current window
            if (lastSeenIndex == null || !isInsideCurrentWindow(windowStart, lastSeenIndex)) {
                lastSeenPositions.put(characters[windowEnd], windowEnd);
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            } else {
                // JUMP: Move window start immediately after the previous occurrence
                windowStart = lastSeenIndex + 1;
            }
        }

        return maxLength;
    }

    /**
     * High-performance version using an integer array for ASCII characters.
     * * Strategy: Uses a Direct Address Table (array) instead of a HashMap to avoid
     * hashing overhead and object allocation.
     * * Time Complexity: O(N) - Single pass.
     * Space Complexity: O(1) - Fixed size array (128 for ASCII) regardless of input
     * size.
     */
    public int lengthOfLongestSubstringOptimizedAscii(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        char[] characters = text.toCharArray();
        int maxLength = 0;
        int windowStart = 0;
        int windowEnd = 0;

        // ASCII mapping: index is the char code, value is (actualIndex + 1)
        int[] lastSeenMap = new int[128];

        while (windowEnd < characters.length) {
            int charCode = characters[windowEnd];
            int lastSeenIndex = lastSeenMap[charCode] - 1;

            if (lastSeenIndex == -1 || !isInsideCurrentWindow(windowStart, lastSeenIndex)) {
                lastSeenMap[charCode] = windowEnd + 1; // Store 1-based index
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            } else {
                windowStart = lastSeenIndex + 1;
            }
        }

        return maxLength;
    }

    /**
     * Helper to verify if the previous occurrence of a character is relevant
     * to the current sliding window.
     */
    private boolean isInsideCurrentWindow(int windowStart, int lastSeenIndex) {
        return lastSeenIndex >= windowStart;
    }
}
package com.github.danimaniarqsoft.challenges.slidingwindows;

import java.util.Arrays;

/**
 * Challenge: Count substrings in 's' that are anagrams of 't'.
 * Pattern: Fixed-Size Sliding Window
 * * Performance:
 * - Time Complexity: O(n) where n is the length of string s.
 * - Space Complexity: O(1) as the frequency array size is constant (26).
 */
public class SubstringAnagrams {

    public int countAnagrams(String s, String t) {
        // Base case: if t is longer than s, no anagrams are possible
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }

        int[] targetFreq = new int[26];
        int[] windowFreq = new int[26];
        int count = 0;
        int tLen = t.length();

        // 1. Initialize the target frequency and the first window
        for (int i = 0; i < tLen; i++) {
            targetFreq[t.charAt(i) - 'a']++;
            windowFreq[s.charAt(i) - 'a']++;
        }

        // 2. Check the first window before sliding
        if (Arrays.equals(targetFreq, windowFreq)) {
            count++;
        }

        // 3. Slide the window across the rest of the string
        // 'right' is the incoming character, 'left' (i - tLen) is the outgoing one
        for (int right = tLen; right < s.length(); right++) {
            // Add the new character entering the window
            windowFreq[s.charAt(right) - 'a']++;

            // Remove the character leaving the window
            windowFreq[s.charAt(right - tLen) - 'a']--;

            // Arrays.equals is highly optimized for small, fixed-size arrays
            if (Arrays.equals(targetFreq, windowFreq)) {
                count++;
            }
        }

        return count;
    }
}
package com.github.danimaniarqsoft.challenges;

/**
 * Validates if a given string is a palindrome.
 * A palindrome is a sequence that reads the same forwards and backwards.
 * This implementation ignores non-alphanumeric characters but is
 * CASE-SENSITIVE.
 */
public class IsPalindromeValid {

    /**
     * Determines if the input string is a valid palindrome.
     * * @param input The string to validate.
     * 
     * @return true if the string is a palindrome, false otherwise.
     *         An empty or null string is considered a valid palindrome.
     */
    public boolean solution(String input) {

        // 1. Handle Edge Case: Null or empty strings are technically palindromes.
        if (input == null || input.length() == 0) {
            return true;
        }

        // Convert the string to a character array for efficient indexed access.
        char[] inputCharts = input.toCharArray();

        // 2. Initialize Two Pointers:
        // 'leftindex' starts at the beginning, 'rightIndex' starts at the end.
        int leftindex = 0;
        int rightIndex = inputCharts.length - 1;

        // 3. Iterate toward the center.
        while (leftindex < rightIndex) {

            // Skip non-alphanumeric characters from the left.
            while (leftindex < rightIndex && !isAlphanumeric(inputCharts[leftindex])) {
                leftindex++;
            }

            // Skip non-alphanumeric characters from the right.
            while (rightIndex > leftindex && !isAlphanumeric(inputCharts[rightIndex])) {
                rightIndex--;
            }

            // 4. Comparison: Check if characters at pointers are different.
            // Note: This check is currently case-sensitive ('A' != 'a').
            if (inputCharts[leftindex] != inputCharts[rightIndex]) {
                return false;
            }

            // Move pointers inward after a successful match.
            leftindex++;
            rightIndex--;
        }

        // If the pointers meet or cross without finding a mismatch, it's a palindrome.
        return true;
    }

    /**
     * Helper method to determine if a character is a letter or a digit.
     * * @param symbol The character to check.
     * 
     * @return true if alphanumeric, false otherwise.
     */
    private boolean isAlphanumeric(char symbol) {
        boolean isLowerCase = symbol >= 'a' && symbol <= 'z';
        boolean isUpperCase = symbol >= 'A' && symbol <= 'Z';
        boolean isNumber = symbol >= '0' && symbol <= '9';

        return isLowerCase || isUpperCase || isNumber;
    }
}
package com.github.danimaniarqsoft.challenges.fastandslowpointers;

/**
 * Challenge: Determine if a number is "Happy".
 * * A number is happy if the sum of the squares of its digits eventually equals
 * 1.
 * If the process loops infinitely without reaching 1, the number is unhappy.
 * * Strategy: Floyd's Cycle-Finding Algorithm (Tortoise and Hare).
 * We treat the sequence of numbers as a virtual linked list where
 * getNextNumber(n)
 * is the "next" pointer.
 */
public class HappyNumber {

    /**
     * Checks if a number is happy using O(1) space.
     * * Time Complexity: O(log n) - The number of digits decreases/stabilizes
     * quickly.
     * Space Complexity: O(1) - No extra data structures like HashSets are used.
     * * @param input The integer to check.
     * 
     * @return true if the number reaches 1, false if it enters a cycle.
     */
    public boolean isHappy(int input) {
        // Handle basic cases
        if (input <= 0)
            return false;
        if (input == 1)
            return true;

        int slow = input;
        int fast = input;

        /*
         * Logic: 'fast' moves twice as fast as 'slow'.
         * 1. If 'fast' hits 1, the number is happy.
         * 2. If 'fast' meets 'slow', they are stuck in a cycle (unhappy).
         */
        do {
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));

            if (fast == 1) {
                return true;
            }
        } while (slow != fast);

        return false;
    }

    /**
     * Calculates the sum of the squares of the digits of a given number.
     * Logic: Uses modulo (%) to get the last digit and division (/) to remove it.
     * * @param number The current number in the sequence.
     * 
     * @return The sum of the squares of its digits.
     */
    private int getNextNumber(int number) {
        int totalSum = 0;
        while (number > 0) {
            int digit = number % 10;
            totalSum += digit * digit;
            number /= 10;
        }
        return totalSum;
    }
}
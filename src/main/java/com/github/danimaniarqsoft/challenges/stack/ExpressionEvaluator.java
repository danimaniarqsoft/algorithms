package com.github.danimaniarqsoft.challenges.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Challenge: Evaluate Expression (Basic Calculator).
 * Pattern: Stack-based Context Management.
 * * Performance Analysis:
 * - Time Complexity: O(n), where n is the length of the string.
 * - Space Complexity: O(n), for the stack in case of nested parentheses.
 */
public class ExpressionEvaluator {

    public int calculate(String s) {
        if (s == null || s.isEmpty())
            return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int currentResult = 0;
        int currentNumber = 0;
        int sign = 1; // 1 represents '+', -1 represents '-'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                // Handle multi-digit numbers
                currentNumber = currentNumber * 10 + (c - '0');
            } else if (c == '+') {
                currentResult += sign * currentNumber;
                currentNumber = 0;
                sign = 1;
            } else if (c == '-') {
                currentResult += sign * currentNumber;
                currentNumber = 0;
                sign = -1;
            } else if (c == '(') {
                // Push the result and sign calculated so far onto the stack
                stack.push(currentResult);
                stack.push(sign);

                // Reset for the inner expression
                currentResult = 0;
                sign = 1;
            } else if (c == ')') {
                currentResult += sign * currentNumber;
                currentNumber = 0;

                // Pop sign first, then the previous result
                currentResult *= stack.pop(); // This is the sign before '('
                currentResult += stack.pop(); // This is the result before '('
            }
        }

        // Add the last number processed
        currentResult += sign * currentNumber;

        return currentResult;
    }
}
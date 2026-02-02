package com.github.danimaniarqsoft.challenges.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Challenge: Valid Parentheses.
 * Pattern: Stack (LIFO - Last In, First Out).
 * * Logic: Every time we see an opening bracket, we expect its corresponding
 * closing bracket to appear after all nested structures are closed.
 */
public class ParenthesesValidator {

    // Using a static Map to avoid re-initializing it on every method call
    private static final Map<Character, Character> BRACKET_PAIRS = new HashMap<>();

    static {
        BRACKET_PAIRS.put('(', ')');
        BRACKET_PAIRS.put('[', ']');
        BRACKET_PAIRS.put('{', '}');
    }

    /**
     * Determines if a string of parentheses is valid.
     * * @param s String containing '(', ')', '[', ']', '{', '}'
     * @return true if pairs are matched and closed in correct order.
     */
    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.isEmpty()) return true;

        // Using Deque as it's faster than the legacy Stack class
        Deque<Character> stack = new ArrayDeque<>();

        

        for (char currentChar : s.toCharArray()) {
            // If the character is a key in our map, it's an OPENING bracket
            if (BRACKET_PAIRS.containsKey(currentChar)) {
                stack.push(currentChar);
            } else {
                // It's a CLOSING bracket
                if (stack.isEmpty()) {
                    return false; // Found a closing bracket with no opening one
                }

                char lastOpened = stack.pop();
                // Check if the current closing bracket matches the last opened one
                if (BRACKET_PAIRS.get(lastOpened) != currentChar) {
                    return false;
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }
}
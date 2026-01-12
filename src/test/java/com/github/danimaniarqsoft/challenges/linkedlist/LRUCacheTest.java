package com.github.danimaniarqsoft.challenges.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

/**
 * Test suite for the Least Recently Used (LRU) Cache.
 * Validates eviction policy, key updates, and retrieval logic.
 */
class LRUCacheTest {

    @ParameterizedTest(name = "{4}")
    @CsvFileSource(resources = "/lru-cache.csv", numLinesToSkip = 1)
    @DisplayName("LRU Cache Operations Sequence")
    void testLRUCache(
            int capacity,
            String operations,
            String args,
            String expected,
            String description) {

        // 1. Arrange: Initialize the Cache and parse commands
        LRUCache cache = new LRUCache(capacity);
        String[] opList = operations.split(",");
        String[] argList = args.split(",");
        String[] expectedList = expected.split(",");

        // 2. Act & Assert: Execute sequence
        for (int i = 0; i < opList.length; i++) {
            String op = opList[i].trim();
            String arg = argList[i].trim();
            String exp = expectedList[i].trim();

            if (op.equals("put")) {
                String[] pair = arg.split(":");
                cache.put(Integer.parseInt(pair[0]), Integer.parseInt(pair[1]));
            } else if (op.equals("get")) {
                int result = cache.get(Integer.parseInt(arg));
                int expectedVal = Integer.parseInt(exp);
                
                assertEquals(expectedVal, result, 
                    String.format("Failed '%s' at step %d for scenario: %s", op, i, description));
            }
        }
    }
}
package com.github.danimaniarqsoft.challenges.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * High-performance Least Recently Used (LRU) Cache.
 * * Strategy:
 * 1. HashMap: Provides O(1) lookup to find the node associated with a key.
 * 2. Doubly Linked List: Maintains the usage order.
 * - Head (Most Recently Used): New or accessed nodes are moved here.
 * - Tail (Least Recently Used): Nodes here are evicted when capacity is
 * exceeded.
 */
public class LRUCache {

    /**
     * Internal Node representing the Doubly Linked List structure.
     */
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node() {
        }

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail; // Dummy boundary nodes
    private int size;

    /**
     * Initializes the LRU Cache with dummy head and tail nodes to simplify edge
     * cases.
     * 
     * @param capacity Maximum number of elements allowed.
     */
    public LRUCache(int capacity) {
        this.capacity = Math.max(0, capacity);
        this.size = 0;
        this.cache = new HashMap<>();

        // Dummy nodes prevent null pointer checks during node movement
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Retrieves a value by key and marks it as the most recently used.
     * Time Complexity: O(1)
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // Move the accessed node to the front (MRU)
        moveToHead(node);
        return node.value;
    }

    /**
     * Adds or updates a key-value pair. Evicts the LRU item if capacity is reached.
     * Time Complexity: O(1)
     */
    public void put(int key, int value) {
        if (capacity == 0)
            return;

        Node node = cache.get(key);

        if (node == null) {
            // New entry
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;

            if (size > capacity) {
                // Evict the Least Recently Used (the one before dummy tail)
                Node lru = popTail();
                cache.remove(lru.key);
                size--;
            }
        } else {
            // Update existing entry
            node.value = value;
            moveToHead(node);
        }
    }

    // --- Helper Methods for List Manipulation ---

    /**
     * Adds a new node immediately after the dummy head.
     */
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * Removes an existing node from the doubly linked list.
     */
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    /**
     * Moves a specific node to the "Most Recently Used" position (head).
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * Removes the node at the end of the list (LRU) and returns it.
     */
    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}
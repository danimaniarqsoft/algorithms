[![GitHub License](https://img.shields.io/github/license/henriquesebastiao/badges?color=blue)](https://github.com/henriquesebastiao/badges/blob/main/LICENSE)


# Project Algorithms

This is an algorithms project

## For run 

Build the project and run all tests with `./mvnw package` or `mvnw.cmd package` for Windows.

# Two Pointers

Here we are goint to explain what are two pointers and how to implemented.

## Pair Sum - Sorted

Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

**Example 1:**

```txt
input: nums = [-5, -2, 3, 4, 6], target = 7
Output = [2, 3]

Explanation: nums[2] + num[3] = 3 + 4
```

**Example 2:**

```txt
input: nums = [1, 1, 1], target = 2
Output = [0, 1]

Explanation: other valid output could be [1, 0], [0, 2], [2, 0],  [1 ,2]
```

## Triplet sum

Given an array of integers, return all triplets `[a, b, c]` such that `a + b + c = 0`. The solution must not contain duplicate triplets (eg., `[1, 2, 3]` and `[2, 3, 1]` are considered duplicate triplets). If no such triplets are found, return an empty array.

Each triplet can be arranged in any order, and the output can be returned in any order.

**Example**

```txt
input: nums = [0, -1, 2, -3, 1]
Output: [[-3, 1, 2], [-1, 0, 1]]
```


## Is Palindrome Valid

A palindrome is a sequence of characters that reads the same forward and backward.

Given a string, determine if it's a palindrome after removing all non-alphanumeric characters. A characters is alphanumeric if it's either a letter or a number.

**Example 1:**

```txt
Input s = "a dog! a panic in a pagoda."
Output: True
```

**Example 2:**

```txt
Input s = "abc123"
Ouput: False
```

**Constraints:**

The string may include a combination of lowercase English letters, numbers, spaces, and punctuations.


## Largest container

You are given an array of numbers, each representing the height of a vertical line on a graph. A container can be formed with any pair of these lines, along with the x-axis of the graph. Return the amount of water which the largest container can hold.

**Example**
```txt
Input: heights = [2, 7, 8, 3, 7, 6]
Output; 24
```

# Hashmaps and Sets

## Pair Sum - Unsorted

Given an array of integers, return the indexes of any two numbers that add up to a target. The order of the indexes in the result doesn't matter. If no pairs is found return an empty array.

**Example**
```txt
Input: nums = [-1, 3, 4, 2], target = 3
Output: [0, 2]

Explanation: nums[0] + nums[2] = -1 + 4 = 3
```

**Constrains:**
- The same index cannot be used twice in the result

## Verify Sudoku Board

Given a partially completed 9x9 Sudoku board, determine if the current state of the board adheres to the rules of the game:
- Each row and column must contain unique numbers between 1 and 9, or be empty (represented as 0)
- Each of the nine 3x3 subgrids that compose the grid must contain unique numbers between 1 and 9, or be empty.

Note: You are asked to determine whether the **current state of the board** is valid given these rules, **not** whether the board is solvable.

**Constraints:**
- Assume each integer on the board falls in the range of [0,9].

## Zero Striping

For each zero in an m x n matrix, set its entire row and column to zero in place.

# Linked List

## Linked List Reversal

Reverse a singly linked list

**Example**

```txt
Input: nums = [1, 2, 3, 4, 5]
Output: [5, 4, 3, 2, 1]

```

## Remove the Kth last Node From a Linked List

Return the head of a singly linked list after removing the Kth node from the end of it.

## Linked List Intersection

Return the node where two singly linked lists intersect. If the linked lists don't intersect, return null.

## LRU Cache

Design and implement a data structure for the Least Resently Used (LRU) Cache that support the following operations

- `LRUCache(capacity: int)` Initialize an LRU Cache with the specified capacity.
- `get(key: int) -> int`: Return the value associated with a key. Return -1 if the key doesn't exist.
- `put(key: int, value: int) -> None`: Add a key and its value to the cache. If adding the key would result in the cache exceeding its size capacity, evict the least recently used element. If the key already exists in the cache, update its value.

**Example:**

Input: [put(1,100), put(2,250),get(2),put(4,300), put(3,200), get(4), get(1)], capacity = 3
Output: [250,300,-1]

**Explanation:**

put(1,100) # cache is [1:100]
put(2,250) # cache is [1:100, 2:250]
get(2)     # return 2050
put(4,300) # cache is [1:100, 2:250, 4:300]
put(3,200) # cache is [2:250, 4:300, 3:200]
get(4)     # return 300
get(1)     # key 1 vas evicted when adding key 3 due to the capacity: return -1

**Constraints:**

- All keys and values are positive integers
- The cache capacity is positive

# Fast and slow pointers

## Linked List Loop

Given a singly linked list, determine if it contains a cyle. A cycle occurs if a node's next pointer reference an earlier node in the list, causing a loop.

## Linked List Midpoint

Given a singly linked list, find and return its middle node. If there are two middle nodes, return the second one.

**Constraints:**

- The linked list containes at least one node.
- The linked list containes unique values.

## Happy Number

In number theory, a happy number is defined as a number that, when repeatedly subjected to the process of squaring its digits and summing those squares, eventually leads to 1 [1].An unhappy number will never reach 1 during this process, and will get stuck in an infinite loop.

**Example:**

```txt
Input: n = 23
Output: True
Explanation: 2^2 + 3^2 = 13 => 1^2 + 3^2 = 10 => 1^2 + 0^2 = 1
```

# Sliding Windows

## Substring Anagrams

Given two strings, s and t, both consistings of lowercase English letters, return the number of substriings in s that are anagrams of t.

An **anagram** is a word or phrase formed by rearranging the letter of another word or phrase, using all the original letters exactly once.

**Example**
```txt
Input: s = "caabab", t = "aba"
Output: 2

Explanation: There is an anagram of t starting at index 1 ("c*aab*ab") and another starting at index 2 ("ca*aba*b")
```

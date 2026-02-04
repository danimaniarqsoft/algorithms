[![GitHub License](https://img.shields.io/github/license/henriquesebastiao/badges?color=blue)](https://github.com/henriquesebastiao/badges/blob/main/LICENSE)

# 🚀 The Algorithms Solution Project: Java Edition

## Project Overview

This repository serves as a comprehensive educational resource for mastering common algorithmic challenges and data structures. Developed with a focus on **Software Engineering excellence**, the project provides clean, well-documented Java solutions to help developers bridge the gap between theoretical knowledge and practical coding proficiency.

The primary focus of this project is the implementation of patterns found in the acclaimed book **"Coding Interview Patterns"** by **Alex Xu & Shaun Guawardance**.

## 🧠 Why This Project?

Rather than focusing on memorizing individual problems, this repository emphasizes **Pattern Recognition**. By mastering a single pattern (like the _Sliding Window_ or _Two Pointers_), you can solve dozens of related problems efficiently.

### Key Patterns Included:

- **Sliding Window:** For problems involving contiguous sub-arrays or strings.
- **Two Pointers:** Optimizing $O(n^2)$ search problems to $O(n)$ time complexity.
- **Fast & Slow Pointers:** Detecting cycles in linked lists and arrays.
- **Merge Intervals:** Handling overlapping intervals in scheduling tasks.
- **Tree & Graph Traversals:** BFS, DFS, and topological sorting strategies.

## 📂 Project Structure
The project follows the standard Maven layout. The logic is separated into foundational structures and pattern-based challenges:

```shell
.
├── src
│   ├── main
│   │   └── java/com/github/danimaniarqsoft
│   │       ├── arrays/             # Array-specific logic (TwoSum)
│   │       ├── challenges/         # Coding Interview Patterns (Sliding Window, etc.)
│   │       ├── graphs/             # Graph implementations
│   │       ├── hashtables/         # Hash Table implementations
│   │       ├── list/               # Linked List and Node definitions
│   │       ├── queues/             # Queue implementations
│   │       ├── recursion/          # Recursive problem sets
│   │       ├── sorting/            # Sorting algorithm implementations
│   │       ├── stack/              # Stack implementations
│   │       ├── trees/              # Tree structures (BST)
│   │       └── utils/              # Tree and Array helper utilities
│   └── test
│       ├── java/...                # JUnit 5 Test Suites
│       └── resources/              # CSV data files for Data-Driven Testing
├── pom.xml                         # Project dependencies and Build config
└── mvnw                            # Maven Wrapper for consistent builds
```

## 🛠️ Tech Stack & Requirements

- **Language:** Java (JDK 17+ recommended)    
- **Build Tool:** Maven
- **Testing Framework:** JUnit 5 (Ensuring all solutions are robust and verified)
    
---

## 🚀 Getting Started

### Prerequisites

Ensure you have the Java Development Kit (JDK) and Maven installed on your machine.

### Installation

Clone the repository to your local machine:

```bash
git clone https://github.com/danimaniarqsoft/algorithms.git
cd algorithms
```

### Build and Run Tests

To verify the solutions and ensure your environment is set up correctly, run the following command in the project root:

**For Unix/macOS:**

Bash

```bash
./mvnw package
```

**For Windows:**

Bash

```bash
mvnw.cmd package
```

> **Note:** Running the `package` command will compile the code, run all unit tests, and generate a JAR file in the `target/` directory.

---

## 📚 Acknowledgments

Special thanks to **Alex Xu** and **Shaun Guawardance** for their incredible work on _Coding Interview Patterns_, which provided the roadmap for these implementations.

---

# Two Pointers

Here we are goint to explain what are two pointers and how to implemented.

## Pair Sum - Sorted

Given an array of integers sorted in ascending order and a target value, return the indexes of any pair of numbers in the array that sum to the target. The order of the indexes in the result doesn't matter. If no pair is found, return an empty array.

**Example 1:**

```py
input: nums = [-5, -2, 3, 4, 6], target = 7
Output = [2, 3]
```

**Explanation:** nums[2] + num[3] = 3 + 4

**Example 2:**

```py
input: nums = [1, 1, 1], target = 2
Output = [0, 1]
```

**Explanation:** other valid output could be [1, 0], [0, 2], [2, 0],  [1 ,2]

## Triplet sum

Given an array of integers, return all triplets `[a, b, c]` such that `a + b + c = 0`. The solution must not contain duplicate triplets (eg., `[1, 2, 3]` and `[2, 3, 1]` are considered duplicate triplets). If no such triplets are found, return an empty array.

Each triplet can be arranged in any order, and the output can be returned in any order.

**Example**

```py
input: nums = [0, -1, 2, -3, 1]
Output: [[-3, 1, 2], [-1, 0, 1]]
```


## Is Palindrome Valid

A palindrome is a sequence of characters that reads the same forward and backward.

Given a string, determine if it's a palindrome after removing all non-alphanumeric characters. A characters is alphanumeric if it's either a letter or a number.

**Example 1:**

```py
Input s = "a dog! a panic in a pagoda."
Output: True
```

**Example 2:**

```py
Input s = "abc123"
Ouput: False
```

**Constraints:**

The string may include a combination of lowercase English letters, numbers, spaces, and punctuations.


## Largest container

You are given an array of numbers, each representing the height of a vertical line on a graph. A container can be formed with any pair of these lines, along with the x-axis of the graph. Return the amount of water which the largest container can hold.

**Example**

```py
Input: heights = [2, 7, 8, 3, 7, 6]
Output: 24
```

# Hashmaps and Sets

## Pair Sum - Unsorted

Given an array of integers, return the indexes of any two numbers that add up to a target. The order of the indexes in the result doesn't matter. If no pairs is found return an empty array.

**Example**
```py
Input: nums = [-1, 3, 4, 2], target = 3
Output: [0, 2]
```

**Explanation:** nums[0] + nums[2] = -1 + 4 = 3

**Constrains:**
- The same index cannot be used twice in the result

### Solution

- [Implementation](src/main/java/com/github/danimaniarqsoft/challenges/twopointers/PairSumSorted.java)
- [Tests](src/test/java/com/github/danimaniarqsoft/challenges/twopointers/PairSumSortedTest.java)

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

```py
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

```py
Input: [put(1,100), put(2,250),get(2),put(4,300), put(3,200), get(4), get(1)], capacity = 3
Output: [250,300,-1]
```

**Explanation:**

```py
put(1,100) # cache is [1:100]
put(2,250) # cache is [1:100, 2:250]
get(2)     # return 2050
put(4,300) # cache is [1:100, 2:250, 4:300]
put(3,200) # cache is [2:250, 4:300, 3:200]
get(4)     # return 300
get(1)     # key 1 vas evicted when adding key 3 due to the capacity: return -1
```

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

```py
Input: n = 23
Output: True
```

**Explanation:** $2^2 + 3^2 = 13$ => $1^2 + 3^2 = 10$ => $1^2 + 0^2 = 1$

# Sliding Windows

## Substring Anagrams

Given two strings, s and t, both consisting of lowercase English letters, return the number of substrings in s that are anagrams of t.

An **anagram** is a word or phrase formed by rearranging the letter of another word or phrase, using all the original letters exactly once.

**Example**

```py
Input: s = "caabab", t = "aba"
Output: 2
```

**Explanation**: There is an anagram of t starting at index 1 ("c**aab**ab") and another starting at index 2 ("ca**aba**b")


## Longest Substring With Unique Characters

Given a string, determine the length of its longest substring that consists only of unique characters.

**Example:**

```py
Input: s = 'abcba'
Output: 3
```

**Explanation:** Substring "abc" is the longest substring of length 3 that contains unique characters ("cba" also fits this description).

## Longest Uniform Substring After Replacements

A uniform substring is one in which all characters are identical. Given a string, determine the `length` of the longest uniform substring that can be formed by **replacing up to k characters**.

**Example:**
```py
Input: s = 'aabcdcca', k = 2
Output: 5
```

**Explanation:** if we can only replace 2 characters, the longest uniform substring we can achieve is "ccccc", obtained by replacing 'b' and 'd' with 'c'.


## Find the Insertion Index

You are given a sorted array that contains unique values, along with an integer target.

- If the array contains the target value, return its index.
- Otherwise, return the insertion index. This is the index where the target would be if it were inserted in order, maintaining the sorted sequence of the array.

**Example 1:**

```py
Input: nums = [1, 2, 4, 5, 7, 8, 9], target = 4
Output: 2
```

**Example 2:**

```py
Input: nums = [1, 2, 4, 5, 7, 8, 9], target = 6
Output: 4
```

**Explanation:** 6 would be inserted at index 4 to be positioned between 5 and 7: `[1, 2, 4, 5, 6, 7, 8, 9]`.


## First and Last Occurrences of a Number

Given an array of integers sorted in non-decreasing order, return the first and last indexes of a target number. If the target is not found, return [-1, -1] .

Example 1:
```py
Input: nums = [1, 2, 3, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11],
       target = 4
Output: [3, 5]
```

Explanation: The first and last occurrences of number 4 are indexes 3 and 5, respectively.

## Cutting Wood

You are given an array representing the heights of trees, and an integer k representing the total length of wood that needs to be cut.

For this task, a woodcutting machine is set to a certain height, H . The machine cuts off the top part of all trees taller than H, while trees shorter than H remain untouched. Determine the highest possible setting of the woodcutter (H) so that it cuts at least k meters of wood.

Assume the woodcutter cannot be set higher than the height of the tallest tree in the array.

Example:

```py
Input: heights = [2, 6, 3, 8], k = 7
Output: 3
```

**Explanation:** The highest possible height setting that yields at least k = 7 meters of wood is 3, which yields 8 meters of wood. Any height setting higher than this will yield less than 7 meters of wood.

**Constraints:**
- It's always possible to attain at least k meters of wood.
- There's at least one tree.

## Find the Target in a Rotated Sorted Array

A rotated sorted array is an array of numbers sorted in ascending order, in which a portion of the array is moved from the beginning to the end. For example, a possible rotation of [1, 2, 3, 4, 5] is [3, 4, 5, 1, 2] , where the first two numbers are moved to the end.

Given a rotated sorted array of unique numbers, return the index of a target value. If the target value is not present, return -1.

Example:

```py
Input: nums = [8, 9, 1, 2, 3, 4, 5, 6, 7], target = 1
Output: 2
```

### Solution

- [Implementation](src/main/java/com/github/danimaniarqsoft/challenges/binarysearch/RotatedSearch.java)
- [Tests](src/test/java/com/github/danimaniarqsoft/challenges/binarysearch/RotatedSortedSearchTest.java)


# Stacks

## Valid Parenthesis Expression

Given a string representing an expression of parentheses containing the characters `(`, `)`, `[`, `]`, `{`, or `}`, determine if the expression forms a valid sequence of parentheses.

A sequence of parentheses is valid if every opening parenthesis has a corresponding closing parenthesis, and no closing parenthesis appears before its matching opening parenthesis.

Example 1:

```py
Input: s = '([]{})'
Output: True
```

Example 2:

```py
Input: s = '([]{)}'
Output: False
```

Explanation: The `(` parenthesis is closed before its nested `{` parenthesis is closed.

### Solution

- [Implementation](src/main/java/com/github/danimaniarqsoft/challenges/stack/ParenthesesValidator.java)
- [Tests](src/test/java/com/github/danimaniarqsoft/challenges/stack/ValidParenthesesTest.java)



## Next Largest Number to the Right

Given an integer array nums, return an output array res where, for each value `nums[i]`, `res[i]` is the first number to the right that's larger than `nums[i]`. If no larger number exists to the right of `nums[i]`, set `res[i]` to `‐1`.

Example:

```py
Input: nums = [5, 2, 4, 6, 1]
Output: [6, 4, 6, -1, -1]
```


### Solution

- [Implementation](src/main/java/com/github/danimaniarqsoft/challenges/stack/NextLargestFinder.java)
- [Tests](src/test/java/com/github/danimaniarqsoft/challenges/stack/NextLargestRightTest.java)
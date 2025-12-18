# Project Algorithms

This is an algorithms project 

## For run 

Build the project and run all tests with `./mvnw package` or `mvnw.cmd package` for Windows.


# Two Pointers

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
package com.github.danimaniarqsoft.challenges;

public class PairSumSorted {

    public int[] solution(int[] input, int target) {

        if (input == null || input.length < 2)
            return new int[0];

        int leftIndex = 0;
        int rightIndex = input.length - 1;

        while (leftIndex < rightIndex) {
            int sum = input[leftIndex] + input[rightIndex];

            if (sum > target) {
                rightIndex = rightIndex - 1;
            } else if (sum < target) {
                leftIndex = leftIndex + 1;
            } else {
                return new int[] { leftIndex, rightIndex };
            }
        }

        return new int[0];
    }

}

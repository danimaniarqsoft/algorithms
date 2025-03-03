package com.github.danimaniarqsoft.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(int[] array, int min, int max) {
        if (min < max) {
            int middle = (int) Math.floor(((double) min + max) / 2);
            mergeSort(array, min, middle);
            mergeSort(array, middle + 1, max);
            merge(array, min, middle, max);
        }
    }

    private static void merge(int[] array, int min, int middle, int max) {

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = min; i <= middle; i++) {
            left.add(array[i]);
        }
        left.add(Integer.MAX_VALUE);

        for (int i = middle + 1; i <= max; i++) {
            right.add(array[i]);
        }
        right.add(Integer.MAX_VALUE);

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = min; i <= max; i++) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                array[i] = left.get(leftIndex);
                leftIndex = leftIndex + 1;
            } else {
                array[i] = right.get(rightIndex);
                rightIndex = rightIndex + 1;
            }
        }
    }

}

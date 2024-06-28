package com.github.danimaniarqsoft.sorting;

import static com.github.danimaniarqsoft.utils.CommonUtils.partition;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int pivotIndex = partition(array, leftIndex, rightIndex);
            quickSort(array, leftIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, rightIndex);
        }
    }

}

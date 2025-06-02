package com.github.danimaniarqsoft.sorting;

import static com.github.danimaniarqsoft.utils.CommonUtils.swap;

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

    private int partition(int[] array, int leftIndex, int rightIndex) {
        int pivot = array[rightIndex];
        int minIndex = leftIndex - 1;

        for (int i = leftIndex; i < rightIndex; i++) {
            if (array[i] < pivot) {
                swap(array, i, ++minIndex);
            }
        }

        swap(array, ++minIndex, rightIndex);
        return minIndex;
    }

}

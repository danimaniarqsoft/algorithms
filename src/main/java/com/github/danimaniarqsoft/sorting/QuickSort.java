package com.github.danimaniarqsoft.sorting;

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
        int pivotValue = array[rightIndex];
        int current = leftIndex - 1;

        for (int i = leftIndex; i < rightIndex; i++) {
            if (array[i] < pivotValue) {
                swap(array, ++current, i);
            }
        }
        swap(array, current + 1, rightIndex);
        return current + 1;
    }

    private void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

}

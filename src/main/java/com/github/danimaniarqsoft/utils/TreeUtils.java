package com.github.danimaniarqsoft.utils;

import static com.github.danimaniarqsoft.utils.CommonUtils.swap;

public class TreeUtils {

    private TreeUtils() {

    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public static int left(int i) {
        return (2 * i) + 1;
    }

    public static int right(int i) {
        return (2 * i) + 2;
    }

    public static void heapify(int[] array, int heapLength, int i) {

        int maxIndex = i;
        int leftIndex = left(i);
        int rightIndex = right(i);

        if (leftIndex < heapLength && array[leftIndex] > array[i]) {
            maxIndex = leftIndex;
        }

        if (rightIndex < heapLength && array[rightIndex] > array[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != i) {
            swap(array, maxIndex, i);
            heapify(array, heapLength, maxIndex);
        }

    }

    public static void buildMaxHeap(int[] array) {
        int heapLength = array.length;
        for (int i = ((array.length) / 2) - 1; i >= 0; i--) {
            heapify(array, heapLength, i);
        }
    }
}

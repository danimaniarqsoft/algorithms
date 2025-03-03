package com.github.danimaniarqsoft.utils;

public class CommonUtils {

    private CommonUtils() {

    }

    public static int partition(int[] array, int minIndex, int maxIndex) {
        int pivot = array[maxIndex];
        int lastMin = minIndex - 1;

        for (int i = minIndex; i < maxIndex; i++) {
            if (array[i] < pivot) {
                lastMin = lastMin + 1;
                swap(array, lastMin, i);
            }
        }

        swap(array, lastMin + 1, maxIndex);
        return lastMin + 1;
    }

    public static void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

}

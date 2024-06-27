package com.github.danimaniarqsoft.sorting;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] data) {
        if (data == null || data.length == 1) {
            return;
        }

        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[i]) {
                    swap(data, j, i);
                }
            }
        }
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}

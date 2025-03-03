package com.github.danimaniarqsoft.sorting;

public class CountingSort implements Sort {

    @Override
    public void sort(int[] array) {
        countingSort(array);
    }

    private void countingSort(int[] array) {
        int maxValue = getMax(array);
        int[] countingArray = new int[maxValue + 1];

        for (int i = 0; i < array.length; i++) {
            countingArray[array[i]] = countingArray[array[i]] + 1;
        }

        for (int i = 1; i < countingArray.length; i++) {
            countingArray[i] = countingArray[i - 1] + countingArray[i];
        }

        int[] newArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int index = countingArray[value] - 1;
            countingArray[value] = countingArray[value] - 1;
            newArray[index] = value;
        }

        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

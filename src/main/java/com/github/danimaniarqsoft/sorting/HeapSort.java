package com.github.danimaniarqsoft.sorting;

import static com.github.danimaniarqsoft.utils.CommonUtils.swap;
import static com.github.danimaniarqsoft.utils.TreeUtils.buildMaxHeap;
import static com.github.danimaniarqsoft.utils.TreeUtils.heapify;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] data) {
        heapSort(data);
    }

    public void heapSort(int[] array) {
        buildMaxHeap(array);
        int heapLength = array.length;
        while (heapLength > 0) {
            swap(array, 0, heapLength - 1);
            heapLength = heapLength - 1;
            heapify(array, heapLength, 0);
        }
    }

}

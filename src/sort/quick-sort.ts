import { swap, left, right } from "./util"
import { Sortable } from "../model/Sortable";


export class Quicksort implements Sortable {

    /**
     * Takes -> O ( k )
     * 
     * @param {*} arr 
     * @param {*} leftIndex 
     * @param {*} rightIndex 
     */
    partition(arr: number[], leftIndex: number, rightIndex: number): number {
        let pivotValue: number = arr[rightIndex];
        let maxMinIndex = leftIndex - 1;

        for (let index = leftIndex; index < rightIndex; index++) {
            if (arr[index] <= pivotValue) {
                maxMinIndex = maxMinIndex + 1;
                swap(arr, index, maxMinIndex);
            }
        }
        maxMinIndex = maxMinIndex + 1;
        swap(arr, maxMinIndex, rightIndex);
        return maxMinIndex;
    }

    quicksort(arr: number[], leftIndex: number, rightIndex: number): void {
        if (leftIndex < rightIndex) {
            let middle: number = this.partition(arr, leftIndex, rightIndex);
            this.quicksort(arr, leftIndex, middle - 1);
            this.quicksort(arr, middle + 1, rightIndex);
        }
    }

    /**
     * Take -> O( n log n )
     * 
     * @param arr 
     */
    sort(arr: number[]) {
        this.quicksort(arr, 0, arr.length - 1);
    }
}
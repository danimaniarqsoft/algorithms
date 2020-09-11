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
    partition(arr: number[], leftIndex: number, rightIndex: number): any {

        let pivot = arr[rightIndex];
        let i = leftIndex = -1;

        for (let j = leftIndex; j < rightIndex; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, rightIndex);
        return i;
    }

    quicksort(arr: number[], leftIndex: number, rightIndex: number): any {
        if (leftIndex < rightIndex) {
            let middle = this.partition(arr, leftIndex, rightIndex);
            this.quicksort(arr, leftIndex, middle - 1);
            this.quicksort(arr, middle + 1, rightIndex);
        }
    }

    sort(arr: number[]) {
        this.quicksort(arr, 0, arr.length - 1);
    }
}
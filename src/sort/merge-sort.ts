import { swap, left, right } from "./util"
import { Sortable } from "../model/Sortable";


export class MergeSort implements Sortable {

    merge = (arr: number[], l: number, m: number, r: number) => {
        let leftArr = [];
        let rightArr = [];

        let n1 = m - l;
        let n2 = r - m - 1;

        for (let index = 0; index <= n1; index++) {
            leftArr[index] = arr[l + index];
        }

        leftArr[n1 + 1] = Number.MAX_SAFE_INTEGER;

        for (let index = 0; index <= n2; index++) {
            rightArr[index] = arr[m + index + 1];
        }

        rightArr[n2 + 1] = Number.MAX_SAFE_INTEGER;

        let i = 0;
        let j = 0;

        for (let index = l; index <= r; index++) {
            if (leftArr[i] <= rightArr[j]) {
                arr[index] = leftArr[i];
                i++;
            } else {
                arr[index] = rightArr[j];
                j++;
            }
        }
    }

    mergeSort = (arr: number[], i: number, j: number) => {
        if (i < j) {
            let middle = Math.floor((i + j) / 2);
            this.mergeSort(arr, i, middle);
            this.mergeSort(arr, middle + 1, j);
            this.merge(arr, i, middle, j);
        }
    }

    sort(arr: number[], maxNum?: number) {
        this.mergeSort(arr, 0, arr.length - 1);
    }

}

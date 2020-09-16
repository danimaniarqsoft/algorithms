import { swap, left, right } from "./util"
import { Sortable } from "../model/Sortable";


export class MergeSort implements Sortable {

    merge = (arr: number[], l: number, m: number, r: number) => {
        let leftArr = [];
        let rightArr = [];

        for (let index = l; index <= m; index++) {
            leftArr.push(arr[index]);
        }
        leftArr.push(Number.MAX_SAFE_INTEGER);

        for (let index = m + 1; index <= r; index++) {
            rightArr.push(arr[index]);
        }
        rightArr.push(Number.MAX_SAFE_INTEGER);

        let leftIndex = 0;
        let rightIndex = 0;

        for (let index = l; index <= r; index++) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[index] = leftArr[leftIndex++];
            } else {
                arr[index] = rightArr[rightIndex++];
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

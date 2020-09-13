import { Sortable } from "@/model/Sortable";
import { swap } from "./util";


export class SelectionSort implements Sortable {

    sort(arr: number[], maxNum?: number) {
        for (let i = 0; i < arr.length; i++) {
            let minIndex = i;
            for (let j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

}
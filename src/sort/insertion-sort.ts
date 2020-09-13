import { Sortable } from "@/model/Sortable";
import { swap } from "./util";


export class InsertionSort implements Sortable {

    sort(arr: number[], maxNum?: number) {
        for (let i = 1; i < arr.length; i++) {
            for (let j = i; (j >= 1) && (arr[j] < arr[j - 1]); j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

}
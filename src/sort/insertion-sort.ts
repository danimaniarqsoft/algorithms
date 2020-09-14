import { Sortable } from "@/model/Sortable";
import { swap } from "./util";


export class InsertionSort implements Sortable {

    sort(arr: number[], maxNum?: number) {
        for (let i = 1; i < arr.length; i++) {
            let j = i;
            while ((arr[i] < arr[j - 1]) && (j >= 1)) {
                swap(arr, j, j - 1);
                j--;
            }

        }
        return arr;
    }

}
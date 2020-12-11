import { Sortable } from "@/model/Sortable";
import { count } from "console";

export class CountingSort implements Sortable {

    sort(arr: number[], maxNumber?: number) {
        // build countArray with max number
        let countArray: number[] = [];

        for (let index = 0; index <= maxNumber; index++) {
            countArray[index] = 0;
        }
        // counting elements in the countArray
        for (let index = 0; index < arr.length; index++) {
            countArray[arr[index]] = countArray[arr[index]] + 1;
        }

        // sum accumulative elements
        for (let index = 1; index < countArray.length; index++) {
            countArray[index] = countArray[index] + countArray[index - 1];
        }

        let sortedArray: number[] = [];

        for (let index = 0; index < arr.length; index++) {
            sortedArray[countArray[arr[index]] - 1] = arr[index];
            countArray[arr[index]] = countArray[arr[index]] - 1;
        }
        // create new Array with sorted elements
        return sortedArray;
    }

}

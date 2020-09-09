const { swap, left, right } = require('./util');

/**
 * Takes -> O ( k )
 * 
 * @param {*} arr 
 * @param {*} leftIndex 
 * @param {*} rightIndex 
 */
exports.partition = (arr, leftIndex, rightIndex) => {

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

exports.quicksort = (arr, leftIndex, rightIndex) => {
    if (leftIndex < rightIndex) {
        let middle = this.partition(arr, leftIndex, rightIndex);
        this.quicksort(arr, leftIndex, middle - 1);
        this.quicksort(arr, middle + 1, rightIndex);
    }
}

exports.sort = (arr) => {
    this.quicksort(arr, 0, arr.length - 1);
}
"use strict";
const { swap, left, right, printTree } = require('./util');
/**
 * Take -> O( log n )
 *
 * @param {*} arr
 * @param {*} i
 */
exports.heapify = (arr, i, heapSize) => {
    let maxIndex = i;
    let leftIndex = left(i);
    let rightIndex = right(i);
    if ((leftIndex < heapSize) && (arr[leftIndex] > arr[maxIndex])) {
        maxIndex = leftIndex;
    }
    if ((rightIndex < heapSize) && (arr[rightIndex] > arr[maxIndex])) {
        maxIndex = rightIndex;
    }
    if (maxIndex != i) {
        swap(arr, i, maxIndex);
        this.heapify(arr, maxIndex, heapSize);
    }
};
/**
 * Takes -> O( n )
 * @param {*} arr
 */
exports.builtMaxHeap = (arr) => {
    let middle = Math.floor(arr.length / 2) - 1;
    for (let index = middle; index >= 0; index--) {
        this.heapify(arr, index, arr.length);
    }
};
/**
 * Takes -> O( n log n )
 *
 * @param {*} arr
 */
exports.sort = (arr) => {
    this.builtMaxHeap(arr);
    for (let heapSize = arr.length; heapSize > 0; heapSize--) {
        swap(arr, 0, heapSize - 1);
        this.heapify(arr, 0, heapSize - 1);
    }
};

"use strict";
const { left, right } = require("./util");
exports.merge = (arr, l, m, r) => {
    let leftArr = [];
    let rightArr = [];
    n1 = m - l;
    n2 = r - m - 1;
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
        }
        else {
            arr[index] = rightArr[j];
            j++;
        }
    }
};
exports.mergeSort = (arr, i, j) => {
    if (i < j) {
        let middle = Math.floor((i + j) / 2);
        this.mergeSort(arr, i, middle);
        this.mergeSort(arr, middle + 1, j);
        this.merge(arr, i, middle, j);
    }
};
exports.sort = (arr) => {
    this.mergeSort(arr, 0, arr.length - 1);
};

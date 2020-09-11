"use strict";
const { swap, left, right } = require('./util');
const { count } = require('console');
exports.sort = (arr, maxNumber) => {
    let countArray = [];
    for (let index = 0; index <= maxNumber; index++) {
        countArray[index] = 0;
    }
    for (let index = 0; index < countArray.length; index++) {
        countArray[arr[index]] = countArray[arr[index]] + 1;
    }
    for (let index = 1; index < countArray.length; index++) {
        countArray[index] = countArray[index] + countArray[index - 1];
    }
    let newArray = [];
    for (let index = 0; index < arr.length; index++) {
        newArray[countArray[arr[index]] - 1] = arr[index];
        countArray[arr[index]] = countArray[arr[index]] - 1;
    }
    return newArray;
};

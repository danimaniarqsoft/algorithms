"use strict";
exports.swap = (arr, left, right) => {
    let temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
};
exports.parent = (i) => {
    return Math.floor((i - 1) / 2);
};
exports.left = (i) => {
    return (2 * i) + 1;
};
exports.right = (i) => {
    return (2 * i) + 2;
};
exports.printTree = (arr) => {
    console.log(' '.repeat(10) + arr);
};
exports.empty = [];
exports.distData = [99, 88, 101, 36, 78, 23, 11, 11, 99, 2, 887, 33, 22, 121];
exports.desData = [887, 121, 101, 99, 99, 88, 78, 36, 33, 23, 22, 11, 11, 2];
exports.ascData = [2, 11, 11, 22, 23, 33, 36, 78, 88, 99, 99, 101, 121, 887];

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
}

exports.right = (i) => {
    return (2 * i) + 2;
}

exports.printTree = (arr) => {
    console.log(' '.repeat(10) + arr);
}

exports.data = [99, 88, 101, 36, 78, 23, 11, 11, 99, 2, 887, 33, 22, 121]
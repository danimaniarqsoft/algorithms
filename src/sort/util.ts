export function swap(arr: number[], left: number, right: number): any {
    let temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
};

export function parent(i: number): any {
    return Math.floor((i - 1) / 2);
};

export function left(i: number): any {
    return (2 * i) + 1;
}

export function right(i: number): any {
    return (2 * i) + 2;
}

export function printTree(arr: number[]): any {
    console.log(' '.repeat(10) + arr);
}

export const empty: number[] = []
export const distData: number[] = [99, 88, 101, 36, 78, 23, 11, 11, 99, 2, 887, 33, 22, 121]
export const desData: number[] = [887, 121, 101, 99, 99, 88, 78, 36, 33, 23, 22, 11, 11, 2]
export const ascData: number[] = [2, 11, 11, 22, 23, 33, 36, 78, 88, 99, 99, 101, 121, 887]

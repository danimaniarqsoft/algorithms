
export class MaximumSubarray {

    /**
     * Kadane algorithm O( n )
     * 
     * @param arr 
     */
    findMaxSubarray(arr: number[]): number[] {
        let start = 0;
        let end = 0;
        let maxSoFar = 0;
        let currentSum = 0;
        let mayStart = 0;


        for (let index = 0; index < arr.length; index++) {
            currentSum = currentSum + arr[index];
            if (maxSoFar <= currentSum) {
                maxSoFar = currentSum;
                end = index;
                start = mayStart;
            }

            if (currentSum < 0) {
                currentSum = 0;
                mayStart = index + 1;
            }

        }

        return [start, end];

    }

}


export class MaximumSubarray {

    /**
     * Kadane algorithm O( n )
     * 
     * @param arr 
     */
    findMaxSubarray(arr: number[]): number[] {
        let maxSoFar = 0;
        let maxTemp = 0;
        let start = 0;
        let end = 0;
        let mayStart = 0;

        for (let index = 0; index < arr.length; index++) {
            maxTemp = maxTemp + arr[index];
            if (maxSoFar <= maxTemp) {
                maxSoFar = maxTemp;
                start = mayStart;
                end = index;
            }

            if (maxTemp < 0) {
                maxTemp = 0;
                mayStart = index + 1;
            }

        }

        return [start, end];
    }

}

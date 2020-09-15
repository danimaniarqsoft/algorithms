import assert = require("assert");
import { empty, distData, ascData, desData } from "../../src/sort/util";
import { MaximumSubarray } from "../../src/dynamic-programming/maximum-subarray";

let test: number[] = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7];

describe('Maximum Subarray problem', () => {

    it('Max Subarray', () => {
        assert.deepEqual(new MaximumSubarray().findMaxSubarray(test), [7, 10]);
    });

});


import assert = require("assert");
import { Quicksort } from '../../src/sort/quick-sort';
import { empty, distData, ascData, desData } from "../../src/sort/util";
import { Sortable } from "../../src/model/Sortable";

let sort: Sortable = new Quicksort();

describe('Quick sort algorithm', () => {

    it('Empty', () => {
        sort.sort(empty)
        assert.deepEqual(empty, []);
    });

    it('Distributed', () => {
        sort.sort(distData)
        assert.deepEqual(distData, ascData);
    });

    it('Ascending', () => {
        sort.sort(ascData)
        assert.deepEqual(ascData, ascData);
    });

    it('Descending', () => {
        sort.sort(desData)
        assert.deepEqual(desData, ascData);
    });

});

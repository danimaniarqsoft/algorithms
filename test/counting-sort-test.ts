import assert = require("assert");
import { empty, distData, ascData, desData } from "../src/sort/util";
import { CountingSort } from "../src/sort/counting-sort";
import { Sortable } from "../src/model/Sortable";

let sort: Sortable = new CountingSort();

describe('Counting sort algorithm', () => {

    it('Empty', () => {
        assert.deepEqual(sort.sort(empty, 0), []);
    });

    it('Distributed', () => {
        assert.deepEqual(sort.sort(distData, 887), ascData);
    });

    it('Ascending', () => {
        assert.deepEqual(sort.sort(ascData, 887), ascData);
    });

    it('Descending', () => {
        assert.deepEqual(sort.sort(desData, 887), ascData);
    });

});


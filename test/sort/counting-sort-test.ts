import assert = require("assert");
import { empty, ascData, getData } from "../../src/sort/util";
import { CountingSort } from "../../src/sort/counting-sort";
import { Sortable } from "../../src/model/Sortable";

let sort: Sortable = new CountingSort();

describe('Counting sort algorithm', () => {

    it('Empty', () => {
        assert.deepStrictEqual(sort.sort(empty, 0), []);
    });

    it('Distributed', () => {
        assert.deepStrictEqual(sort.sort(getData('dist'), 887), ascData);
    });

    it('Ascending', () => {
        assert.deepStrictEqual(sort.sort(getData('asc'), 887), ascData);
    });

    it('Descending', () => {
        assert.deepStrictEqual(sort.sort(getData('desc'), 887), ascData);
    });

});


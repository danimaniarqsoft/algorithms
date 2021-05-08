import assert = require("assert");
import { empty, ascData, getData } from "../../src/sort/util";
import { InsertionSort } from "../../src/sort/insertion-sort";
import { Sortable } from "../../src/model/Sortable";

let sort: Sortable = new InsertionSort();

describe('Insertion sort algorithm', () => {

    it('Empty', () => {
        assert.deepStrictEqual(sort.sort(empty), []);
    });

    it('Distributed', () => {
        assert.deepStrictEqual(sort.sort(getData('dist')), ascData);
    });

    it('Ascending', () => {
        assert.deepStrictEqual(sort.sort(getData('asc')), ascData);
    });

    it('Descending', () => {
        assert.deepStrictEqual(sort.sort(getData('desc')), ascData);
    });

});


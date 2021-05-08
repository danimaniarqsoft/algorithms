import assert = require("assert");
import { empty, ascData, getData } from "../../src/sort/util";
import { HeapSort } from "../../src/sort/heap-sort";
import { Sortable } from "../../src/model/Sortable";

let sort: Sortable = new HeapSort();

describe('Heap sort algorithm', () => {

    it('Empty', () => {
        sort.sort(empty)
        assert.deepStrictEqual(empty, []);
    });

    it('Distributed', () => {
        let data = getData('dist');
        sort.sort(data)
        assert.deepStrictEqual(data, ascData);
    });

    it('Ascending', () => {
        let data = getData('asc');
        sort.sort(data)
        assert.deepStrictEqual(data, ascData);
    });

    it('Descending', () => {
        let data = getData('desc')
        sort.sort(data)
        assert.deepStrictEqual(data, ascData);
    });

});

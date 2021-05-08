import assert = require("assert");
import { Quicksort } from '../../src/sort/quick-sort';
import { empty, ascData, getData } from "../../src/sort/util";
import { Sortable } from "../../src/model/Sortable";

let sort: Sortable = new Quicksort();

describe('Quick sort algorithm', () => {

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
        let data = getData('desc');
        sort.sort(data)
        assert.deepStrictEqual(data, ascData);
    });

});

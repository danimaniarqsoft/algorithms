import assert = require("assert");
import { empty, distData, ascData, desData } from "../../src/sort/util";
import { SelectionSort } from "../../src/sort/selection-sort";
import { Sortable } from "../../src/model/Sortable";

let sort: Sortable = new SelectionSort();

describe('Selection sort algorithm', () => {

    it('Empty', () => {
        assert.deepStrictEqual(sort.sort(empty), []);
    });

    it('Distributed', () => {
        assert.deepStrictEqual(sort.sort(distData), ascData);
    });

    it('Ascending', () => {
        assert.deepStrictEqual(sort.sort(ascData), ascData);
    });

    it('Descending', () => {
        assert.deepStrictEqual(sort.sort(desData), ascData);
    });

});


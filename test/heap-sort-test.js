const assert = require('assert');
const { sort } = require('../sort/heap-sort');
const { empty, distData, ascData, desData } = require('../sort/util');

describe('Heap sort algorithm', () => {

    it('Empty', () => {
        sort(empty)
        assert.deepEqual(empty, []);
    });

    it('Distributed', () => {
        sort(distData)
        assert.deepEqual(distData, ascData);
    });

    it('Ascending', () => {
        sort(ascData)
        assert.deepEqual(ascData, ascData);
    });

    it('Descending', () => {
        sort(desData)
        assert.deepEqual(desData, ascData);
    });

});

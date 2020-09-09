const assert = require('assert');
const { sort } = require('../sort/merge-sort');
const { empty, distData, ascData, desData } = require('../sort/util');

describe('Merge sort algorithm', () => {

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

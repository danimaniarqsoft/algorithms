const assert = require('assert');
const { sort } = require('../sort/counting-sort');
const { empty, distData, ascData, desData } = require('../sort/util');


describe('Counting sort algorithm', () => {

    it('Empty', () => {
        assert.deepEqual(sort(empty, 0), []);
    });

    it('Distributed', () => {
        assert.deepEqual(sort(distData, 887), ascData);
    });

    it('Ascending', () => {
        assert.deepEqual(sort(ascData, 887), ascData);
    });

    it('Descending', () => {
        assert.deepEqual(sort(desData, 887), ascData);
    });

});


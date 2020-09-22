import assert = require("assert");
import { TreeRecursiveSearch } from "../../src/tree-operations/search/TreeRecursiveSearch";
import { TreeIterativeSearch } from "../../src/tree-operations/search/TreeIterativeSearch";
import { Node } from "../../src/model/Node";
import { tree } from "../TestUtil";


describe('BST Search Recursive', () => {

    let op = new TreeRecursiveSearch();
    it('Searching 12', () => {
        let result: Node = op.search(tree.root, 12);
        assert.equal(result.value, 12);
    });

    it('Searching 120', () => {
        let result: Node = op.search(tree.root, 120);
        assert.equal(result, null);
    });

    it('Searching null', () => {
        let result: Node = op.search(tree.root, null);
        assert.equal(result, null);
    });
});

describe('BST Search Iterative', () => {

    let op = new TreeIterativeSearch();
    it('Searching 12', () => {
        let result: Node = op.search(tree.root, 12);
        assert.equal(result.value, 12);
    });

    it('Searching 120', () => {
        let result: Node = op.search(tree.root, 120);
        assert.equal(result, null);
    });

    it('Searching null', () => {
        let result: Node = op.search(tree.root, null);
        assert.equal(result, null);
    });
});

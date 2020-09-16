import assert = require("assert");
import { TreeOperations } from "../../src/traversal/TreeOperations"
import { Node } from "../../src/model/Node";
import { tree } from "../TestUtil";


describe('BST Search', () => {

    let op = new TreeOperations();
    it('Searching 12', () => {
        let result: Node = op.search(tree.root, 12);
        assert.equal(result.value, 12);
    });

    it('Searching 120', () => {
        let result: Node = op.search(tree.root, 120);
        assert.equal(result, null);
    });
});

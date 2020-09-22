import assert = require("assert");

import { Node } from "../../src/model/Node";
import { tree } from "../TestUtil";
import { TreeOperation } from "../../src/tree-operations/common/TreeOperations";


describe('BST Common Operations', () => {

    it('Find Min', () => {
        let minNode: Node = new TreeOperation().findMin(tree.root);
        assert.equal(minNode.value, 1);
    });

    it('Find Max', () => {
        let minNode: Node = new TreeOperation().findMax(tree.root);
        assert.equal(minNode.value, 78);
    });

    it('Find Succesor of 13', () => {
        let succesor: Node = new TreeOperation().succesor(tree.root);
        assert.equal(succesor.value, 13);
    });

    it('Find Succesor of 12', () => {
        let three = tree.root.left.right;
        let succesor: Node = new TreeOperation().succesor(three);
        assert.equal(succesor.value, 12);
    });

    it('Find Succesor of 78', () => {
        let seventyEight = tree.root.right.right;
        let succesor: Node = new TreeOperation().succesor(seventyEight);
        assert.equal(succesor, null);
    });
});

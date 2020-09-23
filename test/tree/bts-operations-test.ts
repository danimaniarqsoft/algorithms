import assert = require("assert");

import { Node } from "../../src/model/Node";
import { tree } from "../TestUtil";
import { TreeOperation } from "../../src/tree-operations/common/TreeOperations";


describe('BST Find Max and Min', () => {

    it('Find Min', () => {
        let minNode: Node = new TreeOperation().findMin(tree.root);
        assert.equal(minNode.value, 1);
    });

    it('Find Max', () => {
        let minNode: Node = new TreeOperation().findMax(tree.root);
        assert.equal(minNode.value, 78);
    });
});


describe('BST Find Successor', () => {

    it('Find Successor of 1', () => {
        let one = tree.root.left.left;
        let succesor: Node = new TreeOperation().succesor(one);
        assert.equal(succesor.value, 2);
    });

    it('Find Successor of 3', () => {
        let three = tree.root.left.right;
        let succesor: Node = new TreeOperation().succesor(three);
        assert.equal(succesor.value, 12);
    });

    it('Find Successor of 12', () => {
        let twelve = tree.root;
        let succesor: Node = new TreeOperation().succesor(twelve);
        assert.equal(succesor.value, 13);
    });

    it('Find Successor of 53', () => {
        let fiftythree = tree.root.right.right.left;
        let succesor: Node = new TreeOperation().succesor(fiftythree);
        assert.equal(succesor.value, 78);
    });

    it('Find Succesor of 78', () => {
        let seventyEight = tree.root.right.right;
        let succesor: Node = new TreeOperation().succesor(seventyEight);
        assert.equal(succesor, null);
    });
});

describe('BST Find Predecessor', () => {

    it('Find Predecessor of 1', () => {
        let one = tree.root.left.left;
        let succesor: Node = new TreeOperation().predecessor(one);
        assert.equal(succesor, null);
    });

    it('Find Predeccessor of 3', () => {
        let three = tree.root.left.right;
        let succesor: Node = new TreeOperation().predecessor(three);
        assert.equal(succesor.value, 2);
    });

    it('Find Predecessor of 12', () => {
        let twelve = tree.root;
        let succesor: Node = new TreeOperation().predecessor(twelve);
        assert.equal(succesor.value, 3);
    });

    it('Find Predecessor of 53', () => {
        let fiftythree = tree.root.right.right.left;
        let succesor: Node = new TreeOperation().predecessor(fiftythree);
        assert.equal(succesor.value, 13);
    });

    it('Find Predecessor of 78', () => {
        let seventyEight = tree.root.right.right;
        let succesor: Node = new TreeOperation().predecessor(seventyEight);
        assert.equal(succesor.value, 53);
    });
});

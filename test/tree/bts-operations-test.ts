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

});

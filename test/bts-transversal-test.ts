import assert = require("assert");
import { PreOrderTraversal } from "../src/traversal/PreOrderTraversal"
import { InOrderTraversal } from "../src/traversal/InOrderTraversal"
import { PostOrderTraversal } from "../src/traversal/PostOrderTraversal"
import { preOrderData, inOrderData, posOrderData, tree } from "./TestUtil";


describe('BST Traversal', () => {

    it('Pre order', () => {
        let result: number[] = [];
        new PreOrderTraversal().traverse(tree.root, (node) => {
            result.push(node.value);
        });
        assert.deepEqual(result, preOrderData);
    });

    it('In order', () => {
        let result: number[] = [];
        new InOrderTraversal().traverse(tree.root, (node) => {
            result.push(node.value);
        });
        assert.deepEqual(result, inOrderData);
    });

    it('Pos order', () => {
        let result: number[] = [];
        new PostOrderTraversal().traverse(tree.root, (node) => {
            result.push(node.value);
        });
        assert.deepEqual(result, posOrderData);
    });

});

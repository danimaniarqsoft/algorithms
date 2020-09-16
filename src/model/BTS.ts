
import { Node } from "./Node";

class BST {
    root: Node;

    constructor() {
        this.root = null;
    };

    add(val: number) {
        let newNode = new Node(val);

        if (!this.root) {
            this.root = newNode;
            return this;
        }

        let currentNode = this.root;

        while (currentNode) {
            if (currentNode.value > newNode.value) {
                if (currentNode.left) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = newNode;
                    currentNode = null;
                }
            } else {
                if (currentNode.right) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = newNode;
                    currentNode = null;
                }
            }
        }
        return this;
    };
};

export { BST };

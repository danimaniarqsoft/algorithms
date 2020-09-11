
import { Node } from "./Node";

class BST {
    root: Node;

    constructor() {
        this.root = null;
    };

    add(val: number) {

        const newNode = new Node(val);
        if (!this.root) {
            this.root = newNode;
            return this;
        };
        let current: Node = this.root;

        const addLeft = () => {
            if (!current.left) {
                current.left = newNode;
                return this;
            }
            current = current.left;
        };

        const addRight = () => {
            if (!current.right) {
                current.right = newNode;
                return this;
            };
            current = current.right;
        };

        while (true) {
            if (val === current.value) return this;
            if (val < current.value) addLeft();
            else addRight();
        };
    };
};

export { BST };

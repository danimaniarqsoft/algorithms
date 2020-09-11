
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

        const addSide = (side: string) => {
            if (!current.left && side === 'left') {
                current.left = newNode;
                return this;
            } else if (!current.right && side === 'right') {
                current.right = newNode;
                return this;
            };
            if (side === 'left') {
                current = current.left;
            } else if (side === 'right') {
                current = current.right;
            };
        };

        while (true) {
            if (val === current.value) return this;
            if (val < current.value) addSide('left');
            else addSide('right');
        };
    };
};

export { BST };

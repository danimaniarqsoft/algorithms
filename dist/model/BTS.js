"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const { Node } = require('./Node');
class BST {
    constructor() {
        this.root = null;
    }
    ;
    create(val) {
        const newNode = new Node(val);
        if (!this.root) {
            this.root = newNode;
            return this;
        }
        ;
        let current = this.root;
        const addSide = side => {
            if (!current[side]) {
                current[side] = newNode;
                return this;
            }
            ;
            current = current[side];
        };
        while (true) {
            if (val === current.val)
                return this;
            if (val < current.val)
                addSide('left');
            else
                addSide('right');
        }
        ;
    }
    ;
}
exports.BST = BST;
;

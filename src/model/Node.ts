class Node {
    value: number;
    parent: Node;
    left: Node;
    right: Node;
    constructor(value: number) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

export { Node };

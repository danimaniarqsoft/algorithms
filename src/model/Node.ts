class Node {
    value: number;
    left: Node;
    right: Node;
    constructor(value: number) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

export { Node };

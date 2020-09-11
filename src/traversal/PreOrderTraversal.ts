import { Traversal } from "@/traversal/Traversal";
import { Node } from "@/model/Node";

export class PreOrderTraversal implements Traversal {
    traverse(node: Node, action: (value: number) => void): void {
        if (node) {
            action(node.value);
            this.traverse(node.left, action);
            this.traverse(node.right, action);
        }
    }
}

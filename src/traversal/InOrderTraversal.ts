import { Traversal } from "@/traversal/Traversal";
import { Node } from "@/model/Node";

export class InOrderTraversal implements Traversal {
    traverse(node: Node, action: (value: number) => void): void {
        if (node) {
            this.traverse(node.left, action);
            action(node.value);
            this.traverse(node.right, action);
        }
    }
}
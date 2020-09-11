import { Traversal } from "@/traversal/Traversal";
import { Node } from "@/model/Node";

export class PostOrderTraversal implements Traversal {
    traverse(node: Node, action: (value: number) => void): void {
        if (node) {
            this.traverse(node.left, action);
            this.traverse(node.right, action);
            action(node.value);
        }
    }
}

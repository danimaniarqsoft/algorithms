import { Traversal } from "@/traversal/Traversal";
import { Node } from "@/model/Node";

export class InOrderTraversal implements Traversal {
    traverse(node: Node, visit: (node: Node) => void): void {
        if (node) {
            this.traverse(node.left, visit);
            visit(node);
            this.traverse(node.right, visit);
        }
    }
}
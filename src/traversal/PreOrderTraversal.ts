import { Traversal } from "@/traversal/Traversal";
import { Node } from "@/model/Node";

export class PreOrderTraversal implements Traversal {
    traverse(node: Node, visit: (node: Node) => void): void {
        if (node) {
            visit(node);
            this.traverse(node.left, visit);
            this.traverse(node.right, visit);
        }
    }
}

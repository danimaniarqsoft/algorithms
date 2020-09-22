import { Traversal } from "@/tree-operations/traversal/Traversal";
import { Node } from "@/model/Node";

export class PostOrderTraversal implements Traversal {
    traverse(node: Node, visit: (node: Node) => void): void {
        if (node) {
            this.traverse(node.left, visit);
            this.traverse(node.right, visit);
            visit(node);
        }
    }
}


import { Node } from "@/model/Node";
export class TreeOperation {

    /**
     * O(h)
     * 
     * @param node 
     */
    findMax(node: Node): Node {
        while (node.right) {
            node = node.right;
        }
        return node;
    }

    /**
    * O(h)
    *
    * @param node
    */
    findMin(node: Node): Node {
        while (node.left) {
            node = node.left;
        }
        return node;
    }

    /**
    * O ( h )
    * 
    * @param node 
    */
    succesor(node: Node): Node {
        if (node.right) {
            return this.findMin(node.right);
        }

        while (node.parent && (node.parent.right === node)) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
    * O ( h )
    *
    * @param node
    */
    predecessor(node: Node): Node {
        if (node.left) {
            return this.findMax(node.left);
        }
        while (node.parent && node.parent.left === node) {
            node = node.parent
        }
        return node.parent;
    }

}
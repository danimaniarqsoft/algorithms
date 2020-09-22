
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

    succesor(node: Node): Node {
        if (node.right) {
            return this.findMin(node.right);
        }

        let currentParent: Node = node.parent;
        let currentChild: Node = node;

        while (currentParent && currentParent.right && (currentParent.right.value === currentChild.value)) {
            currentChild = currentParent;
            currentParent = currentParent.parent;
        }
        return currentParent;
    }

    predecessor(node: Node): Node {
        if (node.left) {
            return this.findMax(node.left);
        }

    }

}
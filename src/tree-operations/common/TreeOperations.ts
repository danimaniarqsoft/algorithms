
import { Node } from "@/model/Node";
export class TreeOperation {

    findMax(node: Node): Node {
        while (node.right) {
            node = node.right;
        }
        return node;
    }

    findMin(node: Node): Node {
        while (node.left) {
            node = node.left;
        }
        return node;
    }

}
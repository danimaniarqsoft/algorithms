import { Node } from "@/model/Node";
import { TreeSearch } from "@/tree-operations/search/TreeSearch";

export class TreeRecursiveSearch implements TreeSearch {

    /**
     *  O( log(n) )
     * 
     * @param node 
     * @param value 
     */
    search(node: Node, value: number): Node {
        if (!node || node.value == value) {
            return node;
        }
        if (node.value > value) {
            return this.search(node.left, value);
        } else {
            return this.search(node.right, value);
        }
    }
}
import { Node } from "@/model/Node";
import { TreeSearch } from "@/tree-operations/search/TreeSearch";

export class TreeIterativeSearch implements TreeSearch {

    /**
     *  O( log(n) )
     * 
     * @param node 
     * @param value 
     */
    search(node: Node, value: number): Node {
        while (node && node.value != value) {
            if (node.value > value) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return node;
    }
}
import { Node } from "@/model/Node";

export interface TreeSearch {

    search(node: Node, value: number): Node;
}
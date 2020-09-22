import { Node } from "@/model/Node";

export interface Traversal {

    traverse(node: Node, visit: (node: Node) => void): void

}

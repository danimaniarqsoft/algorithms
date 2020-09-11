import { Node } from "@/model/Node";

export interface Traversal {

    traverse(node: Node, action: (value: number) => void): void

}

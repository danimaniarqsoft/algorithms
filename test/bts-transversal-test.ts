
import { BST } from "../src/model/BTS";
import { Node } from "../src/model/Node";
import { empty, distData, ascData, desData } from "../src/sort/util";




describe('BST Traversal', () => {

    let tree = new BST();
    tree.add(12).add(13).add(2).add(3).add(78).add(53).add(1);

    console.log(JSON.stringify(tree.root, null, 4));

});

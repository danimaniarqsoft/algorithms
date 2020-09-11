
import { BST } from "../src/model/BTS";
export let tree = new BST().add(12).add(13).add(2).add(3).add(78).add(53).add(1);
export let inOrderData: number[] = [1, 2, 3, 12, 13, 53, 78];
export let preOrderData: number[] = [12, 2, 1, 3, 13, 78, 53];
export let posOrderData: number[] = [1, 3, 2, 53, 78, 13, 12];
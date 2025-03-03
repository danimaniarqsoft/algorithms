package com.github.danimaniarqsoft.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TreeNode {

    private int value;

    private TreeNode left;

    private TreeNode right;

}

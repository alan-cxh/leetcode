package com.alan.leetcode.leetcode.lc0104;

import com.alan.leetcode.common.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * 题意：二叉树的最大深度
 * 难度：Easy
 * 分类：Tree
 * 思路：
 * @author alan
 */

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

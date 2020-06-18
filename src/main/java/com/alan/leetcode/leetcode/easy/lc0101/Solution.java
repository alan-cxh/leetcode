package com.alan.leetcode.leetcode.easy.lc0101;

import com.alan.leetcode.common.TreeNode;

/**
 * 101 Symmetric Tree
 * 题意：对称二叉树
 * 难度：Easy
 * 分类：Tree
 * 思路： 可以借鉴lc0100
 * @author alan
 */

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricCheck(root.left, root.right);
    }

    public boolean isSymmetricCheck(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        } else if (left.val != right.val) {
            return false;
        }
        return isSymmetricCheck(left.left, right.right) && isSymmetricCheck(left.right, right.left);
    }
}

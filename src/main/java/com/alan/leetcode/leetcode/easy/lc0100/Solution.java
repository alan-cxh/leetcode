package com.alan.leetcode.leetcode.easy.lc0100;


import com.alan.leetcode.common.TreeNode;

/**
 * 100 Same Tree
 * 题意：相同的树
 * 难度：Easy
 * 分类：Tree / Depth-first Search
 * 思路： 递归比较两两数值
 * @author alan
 */

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}

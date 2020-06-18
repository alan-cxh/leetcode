package com.alan.leetcode.leetcode.easy.lc0077;


/**
 *
 * 题意：爬楼梯
 * 难度：Easy
 * 分类：动态规划
 * 思路：
 * @author alan
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        // 一步跨两阶时
        dp[0] = 1;
        // 一步跨一阶时
        dp[1] = 2;
        for (int i = 2; i < n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            System.out.println(i + "--" + dp[i]);
        }
        return dp[n - 1];
    }
}

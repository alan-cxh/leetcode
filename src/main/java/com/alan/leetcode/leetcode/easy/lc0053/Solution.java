package com.alan.leetcode.leetcode.easy.lc0053;

/**
 * 53. Maximum Subarray
 * 题意：最大子序和
 * 难度：Easy
 * 分类：Array, Two Pointers
 * 思路：动态规划 DP
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {-5,-2,-10,-2,-2,-3,-2,-3,-4,-5,-4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

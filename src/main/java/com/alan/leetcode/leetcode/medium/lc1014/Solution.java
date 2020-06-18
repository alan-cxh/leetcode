package com.alan.leetcode.leetcode.medium.lc1014;

/**
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 * 题意：最佳观光组合
 * 难度：Easy
 * 分类：Array, DP
 * 思路：
 * @author alan
 */

public class Solution {

    public static void main(String[] args) {
        int[] A = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(A));
    }

    /*（A[i] + A[j] + i - j） = A[j] - j + (A[i] + i)*/
    public static int maxScoreSightseeingPair(int[] A) {
        int res = 0, mx = A[0], begin = 0, end = 0;
        for (int i = 1; i < A.length; i ++) {
            if ((mx + A[i] - i) > res) {
                end = i;
            }
            // 获取第二个点最大值
            res = Math.max(res, mx + A[i] - i);
            if ((A[i] + i) > mx && ((mx + A[i] - i) > res)) {
                begin = i;
            }
            // 获取第一个为参考点的最大值
            mx = Math.max(mx, A[i] + i);
        }
        System.out.println(begin + "---" + end);
        return res;
    }
}

package com.alan.leetcode.leetcode.easy.lc0088;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * 题意：合并两个有序数组
 * 难度：Easy
 * 分类：
 * 思路：
 * @author alan
 */

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(JSON.toJSONString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 先将nums2合并到nums1，在排序
         */
        for (int i = 0; i < n; i ++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}

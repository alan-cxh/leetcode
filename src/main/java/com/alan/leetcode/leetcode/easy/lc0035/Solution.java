package com.alan.leetcode.leetcode.easy.lc0035;

/**
 * 35. Search Insert Position
 * 题意：搜索插入位置
 * 难度：Easy
 * 分类：Array, Binary Search
 * 思路：二分查找
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}

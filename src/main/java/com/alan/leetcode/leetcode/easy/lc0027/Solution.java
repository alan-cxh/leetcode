package com.alan.leetcode.leetcode.easy.lc0027;

import com.alibaba.fastjson.JSON;

/**
 * 27. Remove Element
 * 题意：移除掉数组中指定的值，返回移除后数组的长度
 * 难度：Easy
 * 分类：Array, Two Pointers
 * 思路：两个指针，分别O(n)，指向要交换的位置和和他交换的数
 *      答案中直接遍历一遍数组，放到位置上就行了，i++
 * @author alan
 */
public class Solution {

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     */
    public static int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                n ++;
            }
        }
        return n;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(JSON.toJSONString(nums));
    }
}

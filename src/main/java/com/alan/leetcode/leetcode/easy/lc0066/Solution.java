package com.alan.leetcode.leetcode.easy.lc0066;

import com.alibaba.fastjson.JSON;

/**
 * 66. Plus One
 * 题意：
 * 难度：Easy
 * 分类：Array
 * 思路：
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {9,1,9};
        System.out.println(JSON.toJSONString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i --) {
            if (digits[i] != 9) {
                digits[i] ++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}

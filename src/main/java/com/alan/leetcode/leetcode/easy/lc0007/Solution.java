package com.alan.leetcode.leetcode.easy.lc0007;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * 7. Reverse Integer
 * 题意：反转一个整数
 * 难度：Easy
 * 分类：Math
 * 注意：如何判断溢出
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }


    public static int reverse(int x) {
        int res = 0;
        int newResult;
        int tail;
        while (x != 0) {
            // 求余数
            tail = x % 10;
            newResult = res * 10 + tail;
            if ((newResult - tail) / 10 != res) {
                return 0;
            }
            res = newResult;
            x = x / 10;
        }
        return res;
    }

}

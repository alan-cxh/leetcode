package com.alan.leetcode.leetcode.easy.lc0009;

/**
 * 9. Palindrome Number
 * 题意：判断数字是否是回文数字
 * 难度：Easy
 * 分类：Math
 * 思路：不转换字符串的思路就是把数字反转了以后，比较是否相等
 * Tips：lc5, lc9, lc125, lc131, lc234, lc647
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }

    public static boolean isPalindrome(int x) {
        int temp = x;
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return temp == rev;
    }
}

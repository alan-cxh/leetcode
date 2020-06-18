package com.alan.leetcode.leetcode.easy.lc0028;

/**
 * 28. Implement strStr()
 * 题意：实现 strStr()
 * 难度：Easy
 * 分类：String
 * 思路：窗口移动
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
        System.out.println(strStr("mississippi", "issi"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int cur1 = 0, cur2 = needle.length();

        while (cur1 < haystack.length()) {
            if (cur1 + cur2 <= haystack.length() && needle.equals(haystack.substring(cur1, cur1 + cur2))) {
                return cur1;
            } else {
                // 如果不满足条件，每次窗口又右移动一个位置
                cur1 ++;
            }
        }
        return -1;
    }
}

package com.alan.leetcode.leetcode.easy.lc0014;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 14. Longest Common Prefix
 * 题意：找最长匹配前缀
 * 难度：Easy
 * 分类：String
 * 注意：先排序，再前后两个字符串比较
 * @author alan
 */
public class Solution {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    /**
     * Input: ["flower","flight", "flow"]
     * Output: "fl"
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        StringBuilder result = new StringBuilder();
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < a.length; i ++) {
            if (b.length > i && a[i] == b[i]) {
                result.append(a[i]);
            } else {
                break;
            }
        }
        return result.toString();
    }
}


package com.alan.leetcode.leetcode.easy.lc0058;

/**
 * 58 Length of Last Word
 * 题意：最后一个单词的长度
 * 难度：Easy
 * 分类：Array, Two Pointers
 * 思路：
 * @author alan
 */
public class Solution {



    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }

    public int lengthOfLastWordV2(String s) {
        String[] s1 = s.trim().split(" ");
        return s1[s1.length - 1].length();
    }

}

package com.alan.leetcode.leetcode;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 3. Longest Substring Without Repeating Characters
 * @author: alan chen
 * @create: 2019-03-09 15:06
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * time : O(n)
     * space : O(n)
     * @param s
     * @return res
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i=0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) { // 检查dict中是否存在当前字符
                j = Math.max(j, map.get(s.charAt(i)) + 1); // j 后移(只能往后移)
            }
            map.put(s.charAt(i), i); // 更新dict
            res = Math.max(res, i - j + 1);  // 更新max
        }

        return res;
    }

    public static void main(String[] arg){
        LongestSubstringWithoutRepeatingCharacters_3 s = new LongestSubstringWithoutRepeatingCharacters_3();
        System.out.println(s.lengthOfLongestSubstring("pwwp"));
    }

}

package com.alan.leetcode.leetcode.easy.lc0038;

/**
 * 38. Count and Say
 * 题意：外观数列
 * 难度：Easy
 * 分类：String
 * 思路：
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(2));
        System.out.println(solution.countAndSay(3));
        System.out.println(solution.countAndSay(4));
        System.out.println(solution.countAndSay(5));
    }

    public  String countAndSay(int n) {
        String temp = "1";
        while (n > 1) {
            temp = stay(temp);
            n --;
        }
        return temp;
    }

    private String stay(String temp) {
        StringBuilder result = new StringBuilder();
        char pre = temp.charAt(0);
        int sum = 0;
        for (int i = 0; i < temp.length(); i ++) {
            char ch = temp.charAt(i);
            if (ch == pre) {
                sum ++;
            } else {
                result.append(sum).append(pre);
                sum = 1;
                pre = ch;
            }
            if (temp.length() - 1 == i) {
                result.append(sum).append(pre);
            }
        }
        return result.toString();
    }
}

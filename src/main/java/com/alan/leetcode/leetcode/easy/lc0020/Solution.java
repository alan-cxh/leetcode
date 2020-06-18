package com.alan.leetcode.leetcode.easy.lc0020;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 20. Valid Parentheses
 * 题意：有效的括号
 * 难度：Easy
 * 分类：stack
 * 注意：
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++ ) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

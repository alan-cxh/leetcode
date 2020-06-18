package com.alan.leetcode.leetcode.easy.lc0013;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 13. Roman to Integer
 * 题意：罗马数字转Int
 * 难度：Easy
 * 分类：Math, String
 * 注意：如何解决6种反例，两种方式: (1)判断该位置上与下一位置上大小，决定加减. (2)如何字符串中包含该情况，减去误差
 * @author alan
 */
public class Solution {

    public static void main(String[] args) {

       /* System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt2("LVIII"));
        System.out.println(romanToInt("IL"));*/
        System.out.println(romanToInt2("LVIII"));
    }


    public static int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0, prevValue = 0;
        for(int i = 0; i < s.length(); ++i) {
            Integer value = map.get(s.charAt(i));
            if(value <= prevValue) {
                total += value;
            } else {
                total += value - 2 * prevValue;
            }
            prevValue = value;
        }

        return total;
    }


    public static int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += (res >= 50 ? -10 : 10);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += (res >= 500 ? -100 : 100);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}

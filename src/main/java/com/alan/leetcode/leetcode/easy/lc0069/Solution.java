package com.alan.leetcode.leetcode.easy.lc0069;

/**
 *
 * 题意：x 的平方根
 * 难度：Easy
 * 分类：Math
 * 思路：
 * @author alan
 */

public class Solution {
    public static void main(String[] args) {

        System.out.println(mySqrtV2(2147395599));
    }

    /**
     * 思路：二分查找
     * @param x
     * @return
     */
    public static int mySqrtV2(int x) {
        if (x == 0) {
            return 0;
        }
        int count = 0;
        int left = 1, right = x, res = 0;
        while (left <= right) {
            count ++;
            int mid = left + (right - left) / 2;
            if (mid <= x /mid) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("count === " + count);
        return res;
    }

    /**
     * 思路：暴力法，通过遍历查询
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int res = 1;
        while (true) {
            if (res * res > x) {
                res -= 1;
                break;
            } else if (res * res == x) {
                break;
            }
            res ++;
        }
        return res;
    }
}

package com.alan.leetcode.leetcode.easy.lc0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxinhui
 * @Description:
 * @date 2020/6/15
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;

        int[] r = twoSum(nums,target);
        System.out.println(r[0]);
        System.out.println(r[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return  res;
    }
}

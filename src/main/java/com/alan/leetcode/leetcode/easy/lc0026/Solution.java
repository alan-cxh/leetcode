package com.alan.leetcode.leetcode.easy.lc0026;

import com.alibaba.fastjson.JSON;
import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * 题意：删除排序数组中的重复项
 * 难度：Easy
 * 分类：List Array
 * 注意：
 * @author alan
 */
public class Solution {

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
        System.out.println(JSON.toJSONString(nums));
        System.out.println(JSON.toJSONString(Arrays.copyOfRange(nums, 0, 5)));
    }

    public static int removeDuplicates(int[] nums) {
        int n = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i-1] != nums[i]) {
                nums[n] = nums[i];
                n ++;
            }
        }
        return n;
    }
}

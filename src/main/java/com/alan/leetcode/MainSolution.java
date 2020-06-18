package com.alan.leetcode;

import java.util.TreeSet;

public class MainSolution {

    public static void main(String[] argn){
        Solution solution = new Solution();
        TreeSet<Long> treeSet= new TreeSet();
        treeSet.add(1L);
        treeSet.add(5L);
        treeSet.add(3L);
        treeSet.add(4L);
        //        219
        int[] nums = {1,5,9,1,5,9};
        System.out.println(solution.containsNearbyAlmostDuplicate(nums, 3, 3));


//        int[] arr = {3,2,1,5,6,4};
//        System.out.println(solution.sumByMax(10));

//        System.out.println(solution.combinationSum3(3, 9));

//        218
//        int[][] buildings = {{2, 9, 10}, {3, 7,15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        System.out.println(solution.getSkyline(buildings));



    }
}

package com.alan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {



//    224
//  21 + 287 + 3 - 17 * 1
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int number = 0, sign = 1, result = 0; // number为具体数字;sign为正负数的标志；result为结果

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            }else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // sigh
                result += stack.pop(); // result
            }
        }
        if (number != 0) result += sign * number;
        return result;
    }


//233. Number of Digit One
    public int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k; // r取证，m余数
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }

// 90
    public int countDigitOne1(int n) {
        int count = 0;
        for (int i=1; i <= n; i++) {
            String str = i+"";
            for (int j =0; j < str.length(); j++) {
                char c = new String(i+"").charAt(j);
                if (c == 49) count ++;
            }
        }
        return count;
    }








//    221. Maximal Square
    public int maximalSquare(char[][] a) {
        if (a.length == 0) return 0;
        int n = a[0].length, result = 0;
        int[][] b = new int[a.length+1][n+1];
        for (int i=1; i <= a.length; i ++) {
            for (int j = 1; j < a[0].length; j ++) {
                if (a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1], b[i-1][j-1]), b[i-1][j]) +1;
                    result = Math.max(b[i][j], result);
                }
            }
        }
        return result * result;
    }


    /**
     * 220. Contains Duplicate III
     * @param nums 初始化
     * @param k index间距
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t <= 0) return false;
        TreeSet<Long> treeSet= new TreeSet();
        for (int i =0;i<nums.length;++i){
            Long x = treeSet.ceiling((long)nums[i]-t);
            if(x!=null && x<= (long)nums[i]+t)return true;
            treeSet.add((long)nums[i]);
            if(i>=k){
                treeSet.remove((long)nums[i-k]);
            }
        }
        return false;
    }

//    219. Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i< nums.length; i++) {
            if (map.containsKey(nums[i])){ // 判断是否重复
                // 判断坐标绝对值是否小于等于k值
                int sulute = i - map.get(nums[i]);
                if (sulute <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    // 218. The Skyline Problem
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> high = new ArrayList<>();

        for (int[] b : buildings){
            high.add(new int[]{b[0], -b[2]});
            high.add(new int[]{b[1], b[2]});
        }
        // 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
        Collections.sort(high, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        // create a queue
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(0);
        int prev = 0;
        for (int[] h : high) {
            if (h[1] < 0) {
                queue.offer(-h[1]);
            }else {
                queue.remove(h[1]);
            }
            int cur = queue.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }

//    215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

//    216. Combination Sum III
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combination(lists, new ArrayList<Integer>(), k, 1, n);
        System.out.println(count);
        return lists;
    }
    int count = 0 ;
    // 用到深度递归算法
    private void combination (List<List<Integer>> ans, ArrayList<Integer> comb, int k, int start, int n) {
        if (k < comb.size() || n < 0) return;

        if (comb.size() == k && n == 0) { // 确保列表的长度和累计和为n
            List<Integer> list = new ArrayList<>(comb);
            ans.add(list);
            return;
        }

        for (int i = start; i <= 9; i ++) {
                count ++;
                comb.add(i); // 默认开始第一层
                combination(ans, comb, k, i+1, n-i); // 开始递归操作，进入第二层
                comb.remove(comb.size()-1);

        }

    }


    public int sumByMax(int max){
        if(max>=2){
            int sum = max+sumByMax(max-1);
            return sum;
        }else{
            return max;
        }
    }
}

package com.alan.leetcode.leetcode.lc0118;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxinhui
 * @Description:
 * @date 2020/6/17
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0, 3);
        list.add(0, 2);
        list.add(0, 1);


        System.out.println(JSON.toJSONString(generate(5)));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j ++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }

}

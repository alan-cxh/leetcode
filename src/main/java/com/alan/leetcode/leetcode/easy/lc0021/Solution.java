package com.alan.leetcode.leetcode.easy.lc0021;

import com.alan.leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 21. Merge Two Sorted Lists
 * 题意：合并两个有序链表
 * 难度：Easy
 * 分类：Linked List
 * 注意：递归
 * @author alan
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode m1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = m1(l1.next, l2);
            return l1;
        } else {
            l2.next = m1(l1, l2.next);
            return l2;
        }
    }

}

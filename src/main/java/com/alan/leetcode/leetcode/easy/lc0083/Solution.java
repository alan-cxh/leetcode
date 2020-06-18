package com.alan.leetcode.leetcode.easy.lc0083;

import com.alan.leetcode.common.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * 题意：删除排序链表中的重复元素
 * 难度：Easy
 * 分类： Linked List
 * 思路： 单向链表重复判断
 * @author alan
 */

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            if (p.next == null) {
                break;
            }
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}

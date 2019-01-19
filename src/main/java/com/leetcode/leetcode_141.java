package com.leetcode;

// 1. 将遍历过的元素地址 放到集合中 如果重复 说明有环
// 2. 设置快慢指针 如果存在环 那么快指针一定会超过 慢指针 并且 快指针一次两格 慢指针一次一格， 所以一定相遇

public class leetcode_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow ) return true;
        }
        return false;
    }
}

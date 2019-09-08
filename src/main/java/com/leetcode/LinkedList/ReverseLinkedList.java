package com.leetcode.LinkedList;

import com.leetcode.ListNode;

/**
 * @author liubi
 * @date 2019-09-08 10:16
 **/
public class ReverseLinkedList {
    public  ListNode reverseLinkedList(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        ListNode prev =null;
        ListNode p = listNode;
        ListNode next;
        while (p!=null){
            next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return prev;
    }
}

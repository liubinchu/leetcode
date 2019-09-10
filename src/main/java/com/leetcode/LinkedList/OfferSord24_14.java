package com.leetcode.LinkedList;

import com.leetcode.ListNode;

/**
 * @author liubi
 * @date 2018-11-28 18:13
 **/
public class OfferSord24_14 {
    /**
     * 翻转列表 使用到 三个指针 注意保存被替换的指针
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next== null) {
            return head;
        }
        else {
            ListNode pre = head;
            ListNode ptr = head.next;
            ListNode post = null;
            pre.next = null;
            while(ptr!= null){
                post = ptr.next;
                ptr.next = pre;
                pre = ptr;
                ptr = post;
            }
            return  pre;
        }
    }

    public ListNode ReverseList1(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        OfferSord24_14 solution = new OfferSord24_14();
        solution.ReverseList(new ListNode(10));
    }
}

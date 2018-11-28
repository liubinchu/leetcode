package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-28 15:47
 **/
public class LinkedListParser {
    public ListNode parseLinkedList(int [] array){
        // 建立的是带有头节点的链表 返回的是 不带头节点的链表
        ListNode head = new ListNode(-1) ;
        if(array.length != 0) {
            ListNode index = head;
            for(int val : array){
                ListNode listNode = new ListNode(val);
                index.next = listNode;
                index = index.next;
            }
        }
        return  head.next;
    }
    public static void main(String[] args) {
        LinkedListParser solution = new LinkedListParser();
        int [] array = {1,2,4,5};
        ListNode list = solution.parseLinkedList(array);
        System.getenv();
    }
}

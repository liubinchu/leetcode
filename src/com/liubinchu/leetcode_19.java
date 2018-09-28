package com.liubinchu;

public class leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(-1); //题目定义的构造函数带有参数
        headNode.next = head;
        head = null; // 不用的引用 赋值null 若该对象完全没有引用指向时 被回收

        int count = n;
        ListNode p1 = headNode;
        ListNode p2 = headNode;
        while(count-- >0){
            p1 = p1.next;
        }
        while(p1.next!= null){
            p1 = p1.next;
            p2 = p2.next;
        }
        // 此时p1 指向尾节点 p2 指向要删除的节点的前一个节点 无论要删除的节点是头节点 还是尾节点 情况一样
        // 如果不适用带有头节点的单链表 要删除的点为 头节点 或者 尾节点 时 要单独考虑
        p2.next = p2.next.next;
        return headNode.next;
    }
}

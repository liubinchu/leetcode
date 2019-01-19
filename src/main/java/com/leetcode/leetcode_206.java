package com.leetcode;

public class leetcode_206 {
    /**
     public ListNode reverseList(ListNode head) {
     // when lenght <3
     ListNode p1 = head;
     if(p1 == null) return null;
     ListNode p2 = p1.next;
     if(p2 == null){ p1 = null; return head;}
     ListNode p3 = p2.next;
     if(p3 == null) {p1.next = null;p2.next =p1; p1 = null; head = null; return p2;}
     p1.next = null;
     while(p3 != null){
     p2.next = p1;
     p1 = p2;
     p2 = p3;
     p3 = p3.next;
     }
     //尾节点的反转
     p2.next = p1;
     head = p2;
     p1 = null;
     p2 = null;
     p3 = null;
     return head;
     }
     */
    // 递归解法
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head; // 递归边界
        ListNode pointer = reverseList(head.next); // 递归主体 递归函数 向下递归

        // 发现 递归外面 有些操作没有完成 并且不能放在递归之前进行 一下代码在递归返回时执行
        head.next.next = head;
        // 对于头节点 将其next 指针改为null
        if(head.next.next == head) head.next =null;
        // 也可写为 head.next = null; 在每个递归里 将head.next = null 比较冗余
        // 因为递归 编译器保存了上一层递归的信息 因此能够返回
        return pointer;
    }
}

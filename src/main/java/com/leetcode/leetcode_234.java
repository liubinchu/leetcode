package com.leetcode;

public class leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == null) return true;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 奇数个元素 slow 指向中间元素 fast指向末尾元素 偶数个元素 slow指向n/2-1位置的元素 fast指向null
        ListNode last = slow.next; // 后半段元素指针
        while(last != null && last.next!=null){
            ListNode first = slow.next;// 后半段元素第一个元素
            slow.next = last.next;
            ListNode temp = last.next.next;
            last.next.next = first;
            last.next = temp;
        }// 链表反转的简单方法 一次将当前元素放在头部
        ListNode pre = head;
        ListNode post = slow.next;
        while(post!=null){
            if(pre.val != post.val) return false;
            else{
                pre = pre.next;
                post = post.next;
            }
        }
        return true;
    }
}

package com.leetcode.LinkedList;

import com.leetcode.ListNode;

public class leetcode_21 {
    /**
     * 算法思路： 将list2 中的元素 插入到 list1 合适的位置中
     * 另一种算法 将list1 与 list2 中较小元素 加入到新list 中， 这种方法 建立新list的操作 多于 上一种。
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1,p2,head;
        if(l1==null) return l2;
        else if(l2 == null) return l1;
        else if(l1.val <=l2.val){
            p1 = l1;
            p2 = l2;
        }
        else{
            p1 = l2;
            p2 = l1;
        }
        // p1 元素 小于 p2 元素
        head =p1;
        while(p2 != null){
            if(p1.next == null){
                p1.next = p2;
                //p1指向末尾时
                return head;
            }
            else if(p1.next.val <p2.val){
                p1 = p1.next;
            }
            else{
                ListNode temp1 = p1.next;
                p1.next = p2;
                ListNode temp2 = p2.next;
                p2.next = temp1;
                p2 = temp2;
            }
        }
        return head;
    }
}

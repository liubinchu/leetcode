package com.leetcode.LinkedList;


import com.leetcode.ListNode;

/**
 * @author liubi
 * @date 2018-11-29 10:58
 **/
public class OfferSord25_15 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        leetcode_21 solusion = new leetcode_21();
        return solusion.mergeTwoLists(list1, list2);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0); // head node
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        OfferSord25_15 solution = new OfferSord25_15();
    }
}

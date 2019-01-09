package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-01-08 12:37
 **/
public class OfferSord23_54 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        Set<ListNode> appearedNode = new HashSet<>();
        ListNode pointer = pHead;
        while (pointer!=null){
            if(appearedNode.contains(pointer)){
                return pointer;
            }
            else {
                appearedNode.add(pointer);
            }
            pointer = pointer.next;
        }
        return pointer; // 当不存在环时，能够正常跳出循环，pointer == null
    }
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next.next = p3;
        p1.next.next.next = new ListNode(4);
        p1.next.next.next.next = p3;
        OfferSord23_54 solution = new OfferSord23_54();
        System.out.println(solution.EntryNodeOfLoop(p1).val);
    }
}

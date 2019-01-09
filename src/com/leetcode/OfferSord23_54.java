package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-01-08 12:37
 **/
public class OfferSord23_54 {
    /**
     * 算法分析: 时间复杂度 O（n） 空间复杂度 O（n）
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop1(ListNode pHead)
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

    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null){
            // null element
            return null;
        }
        else if(pHead.next == null){
            // only one element
            return null;
        }

        // define whether exists loop
        ListNode p1 = pHead;
        ListNode p2 = pHead.next.next;
        boolean hasLoop = false;
        while (p1!=null &&p2!=null&&p2.next !=null){
            if(p2 ==p1){
                hasLoop = true;
                break;
            }
            else if (p2.next == p1){
                hasLoop = true;
                break;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if(!hasLoop){
            return null;
        }
        else {
            // define the length of loop/ number of element in loop
            p2 = p1.next;
            int length = 1; // init with 1;
            while (p2!=p1){
                p2 = p2.next;
                length++;
            }
            // define the start element of the loop
            // loop 长度 为 length , 起始部分/非loop部分 长度 为 X
            // p1 p2 init with pHead
            // p1 先走 length 步， 此时 p1，p2 同时向前走  设 走N步
            // 因为 存在loop p2 定能 追上p1
            // 当第一次相遇（此后进入循环 p1===p2），
        }
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

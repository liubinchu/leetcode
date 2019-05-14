package com.leetcode;

/**
 * @author liubi
 * @date 2019-05-14 20:03
 **/
public class leetcode_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        while (pointerA!=null){
            lenA++;
            pointerA = pointerA.next;
        }
        while (pointerB!=null){
            lenB++;
            pointerB = pointerB.next;
        }
        int step = lenA-lenB;
        if (step<0){
            step = -step;
            pointerA = headB;
            pointerB = headA;
        }else {
            pointerA = headA;
            pointerB = headB;
        }
        while (step>0){
            step--;
            pointerA = pointerA.next;
        }
        while (pointerA!=null&&pointerB!=null){
            if(pointerA==pointerB){
                return pointerA; //found
            }
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA; // null
    }
    public static void main(String[] args) {
        leetcode_160 solution = new leetcode_160();
    }
}

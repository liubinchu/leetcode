package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-28 15:46
 **/
public class OfferSord22_13 {
    /**
     * 双指针的思路
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        int count = k;
        ListNode index1 = head;
        while((count--)>0 && index1!= null){
            index1 = index1.next;
        }
        if(count!= -1) {
            // 注意: while((count--)>0 && index1!= null) 当 跳出循环时 count == 0 但是 随后 count -- 所以跳出循环后 count == -1；
            System.out.println("list length is shorter than k");
            return null;
        }
        else{
            ListNode index2 = head;
            while (index1 != null){
                index2 = index2.next;
                index1 = index1.next;
            }
            return index2;
        }
    }
    public static void main(String[] args) {
        LinkedListParser linkedListParser = new LinkedListParser();
        int [] array = {1,2,3,4,5};
        ListNode linkedList = linkedListParser.parseLinkedList(array);
        OfferSord22_13 solution = new OfferSord22_13();
        ListNode result = solution.FindKthToTail(linkedList,1);
        System.getenv();
    }
}

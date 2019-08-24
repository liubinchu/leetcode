package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2018-11-19 10:43
 **/
public class OfferSord06_03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode currNode = listNode;
        if(currNode == null) return result;
        while(currNode != null){
            // O(n)
            result.add(currNode.val);
            currNode = currNode.next;
        }
        int tmp;
        for(int i=0 ;i<result.size()/2;i++){
            tmp = result.get(i);
            result.set(i,result.get(result.size()-1-i));
            result.set(result.size()-1-i,tmp);
        }
        return result;
    }
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if(listNode==null){
            return result;
        }
        else {
            ListNode prev= null;
            ListNode p = listNode;
            while (p!=null){
                ListNode next = p.next;
                p.next = prev;
                prev = p;
                p = next;
            }
            p = prev;
            while (p!=null){
                result.add(p.val);
                p = p.next;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        OfferSord06_03 solution = new OfferSord06_03();
        ListNode listNode1 = new ListNode(67);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode3 = new ListNode(24);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        solution.printListFromTailToHead1(listNode1);
    }
}

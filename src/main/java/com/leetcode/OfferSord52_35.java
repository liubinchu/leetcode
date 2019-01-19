package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-27 10:53
 **/
public class OfferSord52_35 {
    /**
     * 算法分析：1. 如果从后向前访问两个链表的元素 那么一开始其元素都似乎相同的，到某个元素则会不同
     * 利用栈 可以 实现 对链表的逆序访问！！！！！！！！
     * 因此可以利用栈，先将元素分别进入两个栈，然后出栈顺序对应逆序访问顺序
     * 2. 但是上述方法 利用到栈 空间复杂度大， 利用一个特性： 到某个元素开始，两个链表的元素实际上重合，那么可以利用双指针法（在求链表的倒数第k个元素中也用到），将长的链表先走delt（长度差）步，
     * 那么接下来 同时顺序访问，会得到第一个相同的节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //备份
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //计算差值
        int lengthDelt = 0;
        while(pHead1!=null){
            pHead1 = pHead1.next;
            lengthDelt++;
        }
        while (pHead2 !=null){
            pHead2 = pHead2.next;
            lengthDelt--;
        }
        Boolean p1LongerP2 = lengthDelt>0;
        pHead1 = p1;
        pHead2 = p2;
        // 长的链表先走delt步，使得两个链表剩余长度相同
        if(p1LongerP2){
            //p1长
            while(lengthDelt>0){
                pHead1 = pHead1.next;
                lengthDelt--;
            }
        }
        else {
            //p2长
            while(lengthDelt<0){
                pHead2 = pHead2.next;
                lengthDelt++;
            }
        }
        // 求得第一个相同元素
        while(pHead1!=pHead2 && pHead1!=null && pHead2!=null){
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        if(pHead1!=pHead2){
            // 两个链表没有相同元素
            return null;
        }
        else {
            return pHead1;
        }
    }
    public static void main(String[] args) {
        OfferSord52_35 solution = new OfferSord52_35();
    }
}

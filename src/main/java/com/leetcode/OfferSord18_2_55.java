package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-10 09:36
 **/
public class OfferSord18_2_55 {
    /**
     * 算法分析：时间 O（n） 空间O（1）
     * 算法思想：使用一个带头节点的新链表
     * 1. 如果当前元素不存在重复元素/和之后元素不相同，那么加入到新链表中
     * 2. 如果当前元素存在重复元素/和之后元素相同，那么跳过这些元素
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        else {
            ListNode lastNode = new ListNode(-1);// 带头节点的新指针
            ListNode result = lastNode;
            ListNode p = pHead;
            while (p!=null){
                if(p.next==null||p.next.val!=p.val){
                    lastNode.next = p;
                    lastNode = lastNode.next;
                }
                else {
                    while (p.next!=null&&p.val==p.next.val){
                        p = p.next;
                    }
                }
                p = p.next;
            }
            lastNode.next = null;// 记得将新链表尾 赋值为null，否则会接上旧链表剩余元素
            return result.next;
        }
    }
    public static void main(String[] args) {
        OfferSord18_2_55 solution = new OfferSord18_2_55();
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(2);
        p1.next.next.next = new ListNode(3);
        p1.next.next.next.next = new ListNode(4);
        p1.next.next.next.next.next = new ListNode(4);
        p1.next.next.next.next.next.next = new ListNode(5);
        p1.next.next.next.next.next.next.next = new ListNode(5);
        p1 = solution.deleteDuplication(p1);
        while (p1!=null){
            System.out.println(p1.val);
            p1 = p1.next;
        }
    }
}

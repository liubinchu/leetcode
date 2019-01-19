package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-09 18:57
 **/
public class OfferSord35_24 {
    /**
     * 算法思想：
     * 思想一：第一步 顺序复制链表 第二步：在原链表中顺序走 得到随机指针指向的相对位置 第三部 在新链表中 根据相对位置更新random指针 O（n2）
     * 思想二：使用map 记录 新节点 与 旧节点的相对位置关系  空间O（n） 时间O（n） 这也是我一开始的第一反应
     * 思想三：不需要使用map， 利用链表插入元素 方便的特点O（1） 将新元素先插入到原有元素之后， 这样不需要map 就可以保存相对位置
     * 引申： 复制常规的链表也可以使用这样的办法
     * 注意： while(p!=null){*****************} 中 最后一个p 会是null 需要考虑
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode p = pHead;
        if(p == null){
            return null;
        }
        else{
            // step1： 赋值链表节点放置在 原有链表节点之后
            while(p!=null){
                RandomListNode pNew = new RandomListNode(p.label);
                pNew.next= p.next;
                p.next = pNew;
                p = pNew.next;
            }
            RandomListNode pHeadNew = pHead.next;
            // step2：复制random 指针
            p = pHead;
            RandomListNode pNew = p.next;
            while(p!= null){
                if(p.random == null){
                    //注意： while(p!=null){*****************} 中 最后一个p 会是null 需要考虑
                    pNew.random = null;
                }
                else{
                    pNew.random = p.random.next;
                }
                p = pNew.next;
                if(p ==null){
                    //注意： while(p!=null){*****************} 中 最后一个p 会是null 需要考虑
                    pNew = null;
                }
                else {
                    pNew = p.next;
                }
            }
            // step3 : 拆分两个链表，也即 复制next 指针
            p = pHead;
            pNew = p.next;
            while(p!=null){
                p.next = pNew.next;
                p = pNew.next;
                if(p == null){
                    //注意： while(p!=null){*****************} 中 最后一个p 会是null 需要考虑
                    pNew.next = null;
                }
                else {
                    pNew.next = p.next;
                }
                if(p == null){
                    //注意： while(p!=null){*****************} 中 最后一个p 会是null 需要考虑
                    pNew = null;
                }
                else {
                    pNew = p.next;
                }
            }
            return pHeadNew;
        }
    }

    public static void main(String[] args) {
        RandomListNode listNode1 = new RandomListNode(1);
        RandomListNode listNode2 = new RandomListNode(2);
        RandomListNode listNode3 = new RandomListNode(3);
        RandomListNode listNode4 = new RandomListNode(4);
        RandomListNode listNode5 = new RandomListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        listNode1.random = listNode3;
        listNode3.random = listNode5;
        listNode5.random = listNode2;
        listNode2.random = listNode4;

        OfferSord35_24 solution = new OfferSord35_24();
        System.out.println(solution.Clone(listNode1));
        System.out.println("pause");
    }
}

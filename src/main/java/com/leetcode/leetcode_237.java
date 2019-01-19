package com.leetcode;

public class leetcode_237 {
    // 删除 单链表中的节点的某一个节点的常用思路 是将要删除节点的前序节点的指针 指向要删除节点的后序节点
// 但是本题 只给出要删除节点的指针 没有给出头指针 无法按照上述思路进行删除
// 实际上 总结如下 给定一个节点的指针（单链表） 可以删除 可以实际上删除（释放内存）该节点之后的节点
// 因此 分为两个 步骤 1. 将当前节点的值 赋为 下一个节点的值 2. 删除下一个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        // java gc 自动回收 没有引用指向的对象 将要删除的节点的引用赋值为 null 该节点没有引用指向 被回收
        node = null;
        System.gc();
    }
}

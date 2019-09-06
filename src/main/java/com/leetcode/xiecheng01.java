package com.leetcode;

/**
 * @author liubi
 * @date 2019-09-04 19:41
 **/

import java.util.Scanner;

public class xiecheng01 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode() {
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    public static ListNode partition(ListNode head, int m) {
        ListNode res = new ListNode();
        ListNode ptr = head;
        ListNode more = res;
        while (ptr != null) {
            if (ptr.val <= m) {
                ListNode less = res.next;
                ListNode pre = res;
                while (less.val <= m) {
                    pre = less;
                    less = less.next;
                }
                ListNode now = new ListNode(ptr.val);
                pre.next = now;
                now.next = less;
            } else {
                more.next = new ListNode(ptr.val);
                more = more.next;
            }
            ptr = ptr.next;
        }
        return res.next;
    }
/*    static ListNode partition(ListNode head, int target) {
        // write code here
        ListNode lessS = null, lessE = null,
                moreS = null, moreE = null,
                hVal;
        while (head != null) {
            hVal = head.next;
            ires (head.val >= target) {
                ires (moreS != null) {
                    moreE.next = head;
                    moreE = head;
                } else {
                    moreS = moreE = head;
                }
            } else {
                ires (lessE != null) {
                    lessE.next = head;
                    lessE = head;
                } else {
                    lessE = lessS = head;

                }
            }
            head = hVal;
        }
        ires (moreE != null) {
            moreE.next = null;
        }
        ires (lessE != null) {
            lessE.next = moreS;
        } else {
            lessS = moreS;
        }
        return lessS;
    }*/

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}

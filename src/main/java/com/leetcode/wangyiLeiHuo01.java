package com.leetcode;

import java.util.HashSet;
import java.util.List;

public class wangyiLeiHuo01 {
    public static void main(ListNode q) {
        ListNode one_step_cur;
        ListNode two_step_cur;
        one_step_cur = two_step_cur = q.next;

        HashSet<ListNode> visited = new HashSet<>();
        int len = 0;
        while (!visited.contains(one_step_cur) &&
                one_step_cur != null) {
            visited.add(one_step_cur);
            len++;
            one_step_cur = one_step_cur.next;
        }
        int midIndex = (len&1)==0?len/2:len/2+1;
        for (int i=0;i<midIndex;i++){
            two_step_cur = two_step_cur.next;
        }

    }
}

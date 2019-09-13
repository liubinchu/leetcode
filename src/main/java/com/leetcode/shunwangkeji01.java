package com.leetcode;

public class shunwangkeji01 {
    class ListNode {
        Object data;
        ListNode next;

        public ListNode(Object data) {
            this.data = data;
        }
    }

    private ListNode head = new ListNode(null); // head node

    public Object get(int index) {
        ListNode curr = head.next;
        while (index-- > 0) {
            if (curr == null) {
                throw new IndexOutOfBoundsException();
            }
            curr = curr.next;
        }
        return curr.data;
    }

    public Object set(int index, Object o) {
        Object prior = get(index);
        prior = o;
        return o;
    }

    public Object remove(int index) {
        ListNode prev = head;
        while (index-- > 0) {
            if (prev == null) {
                throw new IndexOutOfBoundsException();
            }
            prev = prev.next;
        }
        Object o;
        try {
            o = prev.next.data;
        }catch (NullPointerException e){
            throw new IndexOutOfBoundsException();
        }
        prev.next = prev.next.next;
        return o;
    }

    public boolean isEmpty(){
        return head.next==null;
    }
    public boolean contains(Object o){
        ListNode curr = head.next;
        while (curr!=null) {
            if(curr.data.equals(o)){
                return true;
            }
        }
        return false;
    }
}

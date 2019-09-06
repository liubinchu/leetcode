package com.leetcode;

/**
 * @author liubi
 * @date 2019-09-04 10:04
 **/
public class ClassXiuxiu01 {
    class ListNode {
        char value;
        ListNode next;

        public ListNode(char value) {
            this.value = value;
        }
    }

    public int getSum(ListNode l1, ListNode l2) {
        StringBuilder v1 = new StringBuilder();
        StringBuilder v2 = new StringBuilder();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            v1.append(p1.value);
            p1 = p1.next;
        }
        while (p2 != null) {
            v1.append(p2.value);
            p2 = p2.next;
        }
        int value1 = Integer.parseInt(hexStr2Str(v1.reverse().toString()));
        int value2 = Integer.parseInt(hexStr2Str(v2.reverse().toString()));
        return value1 + value2;
    }

    public ListNode toList(int number) {
        char[] data = String.valueOf(number).toCharArray();
        ListNode list = null;
        if (data.length != 0) {
            list = new ListNode(data[0]);
            ListNode prev = list;
            for (int i = 1; i < data.length; i++) {
                prev.next = new ListNode(data[i]);
                prev = prev.next;
            }
        }
        return list;
    }
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }

    public static void main(String[] args) {

    }
}

package com.leetcode;

/**
 * @author binchu.liu
 * @date 16/08/2019 18:37
 */
public class KeDaXunFei2 {

    public static void main(String[] args) {
/*        Scanner in = new Scanner(System.in);
        String temp = in.nextLine();*/
        String temp = "{11,13,15,17,19,21}";
        int target = 19;
        temp = temp.replace("{", "").replace("}", "");
        String[] temp2 = temp.split(",");
        if (temp2.length == 1 && (temp2[0].equals("") || temp2[0].equals(" "))) {
            System.out.println(-1);
        } else {
            int[] data = new int[temp2.length];
            for (int i = 0; i < temp2.length; i++) {
                data[i] = Integer.parseInt(temp2[i]);
            }
            int index = lowerBound(data, 0, data.length, target);
            if (  index >= data.length||index<0||data[index] != target) {
                System.out.println(-1);
            } else {
                System.out.println(index + 1);
            }
        }
    }

    public static int lowerBound(int nums[], int start, int end, int target) {
        int mid = start + (end - start) / 2;
        if (start >= end) {
            return start;
        } else {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                return lowerBound(nums, mid + 1, end, target);
            } else {
                return lowerBound(nums, start, mid, target);
            }
        }
    }
}

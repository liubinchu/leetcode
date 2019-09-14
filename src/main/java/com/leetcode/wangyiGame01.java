package com.leetcode;

import java.util.*;

public class wangyiGame01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*        String tmp1 = sc.nextLine();
        String tmp2 = sc.nextLine();*/
        String tmp1 = "1,2,3,4";
        String tmp2 = "1,1,3";
        ArrayList<Integer> requirements = new ArrayList<>(tmp1.split(",").length);
        for (String tmp3 : tmp1.split(",")) {
            requirements.add(Integer.parseInt(tmp3));
        }
        Collections.sort(requirements);

        ArrayList<Integer> qualities = new ArrayList<>(tmp2.split(",").length);
        for (String tmp4 : tmp2.split(",")) {
            qualities.add(Integer.parseInt(tmp4));
        }
        Collections.sort(qualities);
/*        List<Integer> requirements = new ArrayList<>();
        requirements.add(1);
        requirements.add(2);
        requirements.add(3);
        requirements.add(4);

        List<Integer> qualities = new ArrayList<>();
        qualities.add(1);
        qualities.add(1);
        qualities.add(3);*/

        System.out.println(greedy(requirements, qualities));

    }

    public static int greedy(List<Integer> requirements, List<Integer> qualities) {
        int res = 0;
        for (int require : requirements) {
            int index = find(qualities, require);
            if (index < qualities.size()) {
                while (qualities.get(index) < require) {
                    index++;
                }
                qualities.remove(index);
                res++;
            }
        }
        return res;
    }

    /**
     * 二分查找 上界 有序数组 升序
     *
     * @param data
     * @return 值的index 的 下界
     */
    public static int find(List<Integer> data, int target) {
        // 二分 只能用在有序情况
        if (data == null || data.size() == 0) {
            return -1;
        }
        int low = 0;
        int high = data.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (data.get(mid) > target) {
                // target 在 0-mid 中
                high = mid;
            } else if (data.get(mid) == target) {
                return mid;
            } else {
                // target 在 mid  - high中
                low = mid + 1;
            }
        }
        return low;
    }
}

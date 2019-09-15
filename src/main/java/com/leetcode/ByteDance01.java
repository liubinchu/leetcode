package com.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ByteDance01 {
    static int k;

    public static Set<Set<Integer>> combinationSelect(Set<Integer> dataSet, int n) {
        return combinationSelect(dataSet, new HashSet<Integer>(), new HashSet<Integer>(), n, new HashSet<Set<Integer>>());
    }

    private static Set<Set<Integer>> combinationSelect(Set<Integer> dataSet,
                                                       Set<Integer> combination,
                                                       Set<Integer> selected,
                                                       int num,
                                                       Set<Set<Integer>> result) {
        if (calSum(combination) >= k) {
            return result;
        }
        if (combination.size() >= num) {
            // 该组合生成完成, 保存结果
            result.add(combination);
            return result;
        }
        // 递归选择下一个
        for (Integer element : dataSet) {
            if (selected.contains(element)) {
                break;
            }
            if (!combination.contains(element)) {
                // 排列结果不存在该项，才可选择
                Set<Integer> combinationCopy = new HashSet<>(combination);
                combination.add(element);
                combinationSelect(dataSet, combination, selected, num, result);
                combination = combinationCopy;
            }
        }
        return result;
    }

    public static int calSum(Set<Integer> combination) {
        int sum = 0;
        for (Integer num : combination) {
            sum += num;
        }
        return sum;
    }


    public static void main(String[] args) {
/*        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedHashSet<Integer> data = new LinkedHashSet<>(n);
        for (int i = 0; i < n; i++) {
            data.add(sc.nextInt());
        }
        k = sc.nextInt();*/
        int n = 6;
        Set<Integer> data = new HashSet<>();
        data.add(-2);
        data.add(0);
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(6);
        k = 2;
        System.out.println(combinationSelect(data, 3).size());
    }
}

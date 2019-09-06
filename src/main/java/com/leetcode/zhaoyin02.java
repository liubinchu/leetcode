package com.leetcode;

import java.util.*;

public class zhaoyin02 {
    /**
     * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1
     *
     * @param n
     * @return
     */
    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

    /**
     * 计算排列数，即A(n, m) = n!/(n-m)!
     *
     * @param n
     * @param m
     * @return
     */
    public static long arrangement(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) : 0;
    }


    /**
     * 排列选择（从列表中选择n个排列）
     *
     * @param dataSet 待选择的元素集合
     * @param n       选择个数
     * @param print   是否打印排列数
     */
    public static <T> Set<List<T>> arrangementSelect(Set<T> dataSet, int n, boolean print) {
        if (print) {
            System.out.println(String.format("A(%d, %d) = %d", dataSet.size(), n, arrangement(dataSet.size(), n)));
        }
        Set<List<T>> result = new HashSet<>();
        arrangementSelect(dataSet, new ArrayList<T>(), n, result);
        return result;
    }

    /**
     * 排列选择
     *
     * @param dataSet     待排列元素集合 dataSet 中 不存在重复集合
     * @param arrangement 一个排列
     * @param num         排列的元素个数 也即A（m，n） 中的n
     * @param result      结果集合
     */
    private static <T> void arrangementSelect(Set<T> dataSet, List<T> arrangement, int num, Set<List<T>> result) {
        if (arrangement.size() >= num) {
            // 改排列生成完成, 保存结果
            result.add(arrangement);
        } else {
            // 递归选择下一个
            for (T element : dataSet) {
                if (!arrangement.contains(element)) {
                    // 排列结果不存在该项，才可选择
                    List<T> arrangementCopy = new ArrayList<>(arrangement);
                    arrangementCopy.add(element);
                    arrangementSelect(dataSet, arrangementCopy, num, result);
                }
            }
        }
    }


    /**
     * @param dataSet     其中元素允许重复
     * @param arrangement
     * @param selectNum
     * @param result
     * @param <T>
     * @throws Exception
     */
    private <T> void arrangement(LinkedList<T> dataSet, List<T> arrangement, int selectNum, Set<List<T>> result) throws Exception {
        if (arrangement.size() > selectNum) {
            throw new Exception("compute error");
        } else if (selectNum == 0) {
            return;
        } else if (arrangement.size() == selectNum) {
            result.add(arrangement);
        } else {
            for (T element : dataSet) {
                List<T> arrangementCopy = new ArrayList<>(arrangement);
                arrangementCopy.add(element);
                LinkedList<T> dataSetCopy = new LinkedList<>(dataSet);
                dataSetCopy.remove(element);
                arrangement(dataSetCopy, arrangementCopy, selectNum, result);
            }
        }
    }

    public static boolean justify(List<String> data) {
        if (data.contains("C")) {
            return false;
        }
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals("B") && i + 1 < data.size() && data.get(i + 1).equals("B")) {
                return false;
            }
        }
        return true;
    }

    public static int fun(int n) {
        int res = 0;
        Set<String> mark = new HashSet<>();
        mark.add("A");
        mark.add("B");
        mark.add("C");
        Set<List<String>> datas = arrangementSelect(mark, n, false);
        System.out.println(datas);
        for (List<String> data : datas) {
            if (justify(data)) {
                res++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Integer a =20,b=20,c=200,d=200;
        System.out.println(b==(a*10));
    }
}

package com.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author binchu.liu
 * @date 23/08/2019 19:48
 */
public class beike01 {
    private static <T> Set<Set<T>>  combinationSelect(Set<T> dataSet,
                                                      Set<T> combination,
                                                      Set<T> selected,
                                                      int num,
                                                      Set<Set<T>> result) {
        if (combination.size() >= num) {
            // 该组合生成完成, 保存结果
            result.add(combination);
            return result;
        }
        // 递归选择下一个
        for(T element : dataSet){
            if(selected.contains(element)){
                break;
            }
            if(!combination.contains(element)){
                // 排列结果不存在该项，才可选择
                Set<T> combinationCopy = new HashSet<>(combination);
                combination.add(element);
                combinationSelect(dataSet, combination,selected,num, result);
                combination = combinationCopy;
            }
        }
        return result;
    }

    public static <T> Set<Set<T>> combinationSelect(Set<T> dataSet, int n) {

        return  combinationSelect(dataSet,new HashSet<T>(),new HashSet<T>(),n,new HashSet<Set<T>>());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        Set<Integer> data = new HashSet<>(n);
        for(int i=0;i<n;i++){
            data.add(in.nextInt());
        }
        Set<Set<Integer>> res = new HashSet<>();
        for(int i=0;i<n;i++){
            res.addAll(combinationSelect(data ,i));
        }
         int maxNum = Integer.MIN_VALUE;
        for(Set<Integer> combination : res){
            int sum =0;
            for (Integer num : combination){
                sum+=num;
            }
            if(sum<=s&&combination.size()>maxNum){
                maxNum = combination.size();
            }
        }
        System.out.println(maxNum);
    }
}

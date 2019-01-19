package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author liubi
 * @date 2018-12-10 19:19
 **/
public class OfferSord40_28 {
    /**
     * 算法分析： 思路一，利用堆， java中优先队列的底层就是最小堆， 自定义比较器 可以改为最大堆
     * 时间复杂度堆排序的时间复杂度 O（n * logk） 每次从堆中进行排序都是logk 的复杂度
     * 适用于 海量数据 但是k比较小的情况 k可以存入内存
     * 思路二： 基于partition 的方法 ; 待实现
     */
    public static Comparator<Integer> largeComparater = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k>input.length||input.length==0){
            return new ArrayList<Integer>();
        }
        PriorityQueue<Integer> res= new PriorityQueue<>(largeComparater);
        for(Integer element: input){
            res.offer(element);
            if(res.size()>k){
                res.poll();
            }
        }
        Integer[] r = new Integer[k];
        res.toArray(r);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0 ;i<k;i++){
            result.add(r[k-i-1]);
        }
        return  result;
    }
    public static void main(String[] args) {
        OfferSord40_28 solution = new OfferSord40_28();
        int[] input  = {8,9,10,1,2,3,4,5,6,7};
        System.out.println(solution.GetLeastNumbers_Solution(input,3));
    }
}

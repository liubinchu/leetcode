package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-27 21:18
 **/
public class OfferSord53_36 {
    /**
     * 本质上是二分搜索/ 采用经典版C++ STL中的写法 能过在本题中减少复杂度
     * 二分的写法 参考 https://www.zhihu.com/question/36132386/answer/530313852
     * 关键点： 左闭右开区间
     * @param data
     * @param value
     * @return
     */
    private int lowerBound(int[] data,int value){
        /**
         * 求第一个不小于value的值的位置，也即求给定值的下界，数组非降序
         */
        int first = 0;
        int last = data.length;
        int mid = 0;
        // mid = ( first + last )/2 的写法 容易导致 两数相加导致的int 溢出
        while (first<last){
            mid = first + (last -first)/2;
            if(data[mid] < value){
                first = mid +1 ;
            }
            else {
                last = mid;
            }
        }
        return first;
    }

    private int upperBound(int [] data, int value){
        /**
         * 求第一个大于value的值的位置，也即求给定值的上界，数组非降序
         * 也即 求第一个不小于value+1的值的位置
         */
        int first= 0;
        int last = data.length;
        int mid = 0;
        while (first <last){
            mid = first + (last - first) /2;
            if(data[mid] < value +1){
                first = mid +1;
            }
            else {
                last = mid;
            }
        }
        return first;
    }
    public int GetNumberOfK(int [] array , int k) {
        int lowerBound = this.lowerBound(array,k);
        int upperBound = this.upperBound(array,k);
        return upperBound - lowerBound;
    }
    public static void main(String[] args) {
        OfferSord53_36 solution = new OfferSord53_36();
    }
}

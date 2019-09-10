package com.leetcode.Array;

/**
 * @author liubi
 * @date 2018-11-28 10:19
 **/
public class OfferSord21_12 {
    /**
     * T O(2n)
     * S O(n)
     * 另一种思路： 索引排序法 本质上相同 但是如果待排元素是一个比较大的对象 新建的数组可以指存储索引
     * 这道题 本质上是 要求 稳定的排序算法。
     * 排序方法	平均时间	最好时间	最坏时间
     * 桶排序(不稳定)	O(n)	O(n)	O(n)
     * 基数排序(稳定)	O(n)	O(n)	O(n)
     * 归并排序(稳定)	O(nlogn)	O(nlogn)	O(nlogn)
     * 快速排序(不稳定)	O(nlogn)	O(nlogn)	O(n^2)
     * 堆排序(不稳定)	O(nlogn)	O(nlogn)	O(nlogn)
     * 希尔排序(不稳定)	O(n^1.25)	 	 
     * 冒泡排序(稳定)	O(n^2)	O(n)	O(n^2)
     * 选择排序(不稳定)	O(n^2)	O(n^2)	O(n^2)
     * 直接插入排序(稳定)	O(n^2)	O(n)	O(n^2)
     * 但是提升不大 因此 选择 时间换空间的方法也很好
     * @param array
     */
    public void reOrderArray(int [] array) {
        int[] arrayCopy = new int[array.length];
        //System.arraycopy(array, 0, arrayCopy, 0, array.length);
        int index = 0;
        for (int anArray : array) {
            if ((anArray & 1) == 1) {
                arrayCopy[index++] = anArray;
            }
        }
        for (int anArray : array) {
            if ((anArray & 1) == 0) {
                arrayCopy[index++] = anArray;
            }
        }
        System.arraycopy(arrayCopy,0,array,0,array.length);
    }
    public static void main(String[] args) {
        OfferSord21_12 solution = new OfferSord21_12();
        int [] array = {1,2,3,4,5,6};
        solution.reOrderArray(array);
        for(Integer i : array){
            System.out.print(i.toString()+" ");
        }
    }
}

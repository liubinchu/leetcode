package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-10 20:49
 **/
public class OFferSord42_29 {
    /**
     * 解法二： 动态规划：f（n） 表示以element_n 结尾的最大连续字串和 的值 那么 f（n）= max( f（n-1）+element_n , element_n )
     * 时间复杂度O（n）
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0) {
            return 0;
        }
        else{
            int currentRes = array[0];
            int lastRes = array[0];
            int maxSum = Integer.MIN_VALUE;
            for(int i = 1; i<array.length;i++){
                //currentRes = lastRes + array[i] > array[i]? lastRes+array[i]: array[i];
                if(lastRes>0){
                    currentRes = lastRes+array[i];
                }
                else {
                    currentRes = array[i];
                }
                //maxSum = maxSum>currentRes? maxSum:currentRes;
                if(maxSum <currentRes){
                    maxSum  = currentRes;
                }
                lastRes = currentRes;
            }
            return maxSum;
        }
    }

    /**
     * 解法一： 动态规划算法 f（n）表示从第一个元素开始到第n个元素中 最大字串和的值 那么 f（n）= max( f(n-1) , 以element_n 元素结尾的最大字串和)
     * 时间复杂度O（n2） 其中相比于算法二 复杂的地方在于 求以element_n 元素结尾的最大字串和 O(n)， 如果对这一部分 使用动态规划的算法 那么 可以由O（n）降至O（1）
     *
     * 解析： 应该用动态规划算法时 往往能够 降低一个幂级的时间复杂度， 本例中 对于最外层 求整体的最大字串和 使用dp 没有降低时间复杂度 对于 内层 求以element_n 结尾的元素的最大字串和 应用dp可以降低时间复杂度
     * 因此 应用dp 时 应该 分析 应用后的效果 如果 没有降低时间复杂度 不妨 将其应用至内层算法
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        if(array.length==0) {
            return 0;
        }
        else{
            int currentRes = Integer.MIN_VALUE;
            int lastRes = Integer.MIN_VALUE;
            for(int i = 0; i<array.length;i++){
                int maxSum =array[i];
                int accSum =maxSum;
                for(int j=i-1;j>=0;j--){
                    accSum+=array[j];
                    maxSum = accSum>maxSum?accSum:maxSum;
                }
                currentRes = maxSum>lastRes?maxSum:lastRes;
                lastRes = currentRes;
            }
            return currentRes;
        }
    }
    public static void main(String[] args) {
        OFferSord42_29 solution = new OFferSord42_29();
        int[] input  ={-2,-8,-1,-5,-9};
        System.out.println(solution.FindGreatestSumOfSubArray(input));
    }
}

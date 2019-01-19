package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-04 09:37
 **/
public class OfferSord57_1_41 {
    /**
     * 算法解析：
     * 1.要求输出两个数的乘积最小的，且是递增序列，那么根据数学规律 找到的第一个pair，乘积最小（1*9 < 5*5）
     * 2. 主要思想： 先遍历确定第一个数 num1， 再二分查找满足条件的targetNum2
     * 3. 时间复杂度                   n              *            log（n）
     * 4. 二分的标准写法： 左闭右开区间 OfferSord53_36 中lowerBound 写法
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum_1(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array.length == 0){
            return result;
        }
        int maxNum = array[array.length-1];
        int minNum = array[0];
        for(int i =0;i<array.length;i++){
            int num1 = array[i];
            int targetNum2 = sum - num1;
            if(targetNum2<=maxNum && targetNum2>=minNum){
                int low = i;
                int high = array.length;
                while(low<high){
                    int mid = low + (high-low)/2;
                    if(array[mid]<targetNum2){
                        low = mid+1;
                    }
                    else {
                        high = mid;
                    }
                }
                if(array[low] == targetNum2){
                    result.add(num1);
                    result.add(targetNum2);
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 算法分析：
     * 时间复杂度O（n） 详见剑指offer 书籍
     * @param array
     * @param targetSum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int targetSum) {
        ArrayList<Integer> result = new ArrayList<>();
        switch (array.length){
            case 0:
                break;
            case 1:
                break;
            case 2:
                if(array[0]+array[1]==targetSum){
                    result.add(array[0]);
                    result.add(array[1]);
                }
                break;
            default:
                int index1 = 0;
                int index2 = array.length-1;
                int sum ;
                while(index1<index2){
                    sum = array[index1]+ array[index2];
                    if(sum<targetSum){
                        index1++;
                    }
                    else if(sum>targetSum){
                        index2--;
                    }
                    else if(sum==targetSum){
                        result.add(array[index1]);
                        result.add(array[index2]);
                        break;
                    }
                }
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSord57_1_41 solution = new OfferSord57_1_41();
        int[] array = {};
        int sum =0;
        System.out.println(solution.FindNumbersWithSum(array,sum));
    }
}

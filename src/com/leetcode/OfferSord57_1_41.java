package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-04 09:37
 **/
public class OfferSord57_1_41 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
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
    public static void main(String[] args) {
        OfferSord57_1_41 solution = new OfferSord57_1_41();
        int[] array = {};
        int sum =0;
        System.out.println(solution.FindNumbersWithSum(array,sum));
    }
}

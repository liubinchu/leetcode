package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-18 19:36
 **/
public class OfferSord51_34 {
    public int InversePairs(int [] array) {
        int counter = 0;
        if(array.length == 0|| array.length == 1) {
            counter = 0;
        }
        else {
            for(int i = array.length-2;i>=0;i--){
                int currentNum = array[i];
                for(int j=i+1;j<array.length;j++){
                    if(array[j] < currentNum){
                        array[j-1] = array[j];
                        array[j] = currentNum;
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
        return  counter;
    }

    public static void main(String[] args) {
        OfferSord51_34 solution = new OfferSord51_34();
        int[] test = {1,2,3,4,5,6,7,0};
        solution.InversePairs(test);
    }
}

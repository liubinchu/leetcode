package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-21 18:31
 **/
public class OfferSord11_06 {
    private void reverseArray(int[] array, int startIndex, int length){
        int counter = length/2;
        while(counter-->0){
            int temp = array[startIndex+counter-1];
            array[startIndex+counter-1] = array[startIndex+length-counter];
            array[startIndex+length-counter] = temp;
        }
    }
    private int[] getOriginArray(int [] array) {
        if(array.length==0)
        {
            return array;
        }
        else{
            int changeIndex = 0;
            for(int i= 0 ; i<array.length-1;i++){
                if(array[i]>array[i+1])
                {
                    changeIndex = i;
                    break;
                }
            }
            reverseArray(array,0,changeIndex+1);
            reverseArray(array,changeIndex,array.length-changeIndex-1);
            reverseArray(array,0,array.length);
            // 至此得到旋转前的数组
            return array;
        }
    }
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) {
            return 0;
        }
        else{
            int resultIndex = 0;
            for(int i = 0 ; i<array.length-1;i++){
                if(array[i]>array[i+1]){
                    resultIndex = i+1;
                    break;
                }
            }
            return array[resultIndex];
        }
    }
    public static void main(String[] args) {
        OfferSord11_06 solution = new OfferSord11_06();
        int[] array = {1,2,3,4};
        solution.minNumberInRotateArray(array);
    }
}

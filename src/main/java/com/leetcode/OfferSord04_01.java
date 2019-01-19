package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-19 09:01
 **/
public class OfferSord04_01 {
    public boolean Find(int target, int [][] array) {
        boolean finded = false;
        for(int[] subArray : array){
            // 检查每一行
            if((subArray.length == 0) || target>subArray[subArray.length-1] && target<subArray[0]){
                //subArray.length == 0 当前子数组个数为0 否则后面的判断会数组越界
                continue;
            }
            else{
                // target在该数组 最大最小值范围内
                for(int num :subArray){
                    if(num == target)
                        finded = true;
                }
            }
        }
        return finded;
    }
    public static void main(String[] args) {
        OfferSord04_01 solution = new OfferSord04_01();
        int[][] array = {{1,2},{3,4},{5,6}};
        solution.Find(10,array);
    }
}

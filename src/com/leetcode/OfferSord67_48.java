package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 18:45
 **/
public class OfferSord67_48 {
    public int StrToInt(String str) {
        int pow = 1;
        int res =0;
        int currentNum = 0;
        Boolean positive = true;
        for(int i=str.length()-1;i>=0;i--){
            currentNum = (int) str.charAt(i)-48;
            if(currentNum<=9&&currentNum>=0){
                res+=pow*currentNum;
            }
            else if(currentNum==-3 && i==0){
                //negative number
                return -res;
            }
            else if (currentNum==-5 && i==0) {
                // positive number with positive flag eg. +121387
                return res;
            }
            else {
                // string不符合数字要求时返回0
                return 0;
            }
            pow*=10;
        }
        // positive number without positive flag eg. 121387
        return res;
    }
    public static void main(String[] args) {
        OfferSord67_48 solution = new OfferSord67_48();
        System.out.println(solution.StrToInt("+1234556780"));

    }
}

package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-07 18:45
 **/
public class OfferSord67_48 {
    Boolean illegalInput = false;

    /**
     * 算法解析： 实现atoi 算法思想比较简单 但是难点在于考虑全面
     * 1.出现非法字符？
     * 2. 正负数
     * 3. 正负号出现在数字中间
     * 4. 非法输入返回0 与正常输入 转换为0 之间的区别 C++ 中atoi利用全局变量进行区分，这里我用类成员变量进行区分
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        int pow = 1;
        int res =0;
        int currentNum = 0;
        Boolean positive = true;
        for(int i=str.length()-1;i>=0;i--){
            currentNum = (int) str.charAt(i)-'0';
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
                this.illegalInput = true;
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

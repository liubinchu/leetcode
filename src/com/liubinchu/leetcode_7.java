package com.liubinchu;

public class leetcode_7 {
    // 两个点 1/ 如何判断 数值范围越界  2. 如何反转  不断 %10 /10 取得最有一位   结果变量 不断 *10+取得的最有一位
    public int reverse(int x) {
        int number = x ;
        int temp1 = 0;
        int temp2 = 0;
        int res = 0;
        while(number!= 0){
            temp1 = number%10; // 取得最后一位
            number = number/10; // 前进一位
            temp2 = res*10 + temp1;
            if((temp2/10)!= res){// 越界了
                return 0;
            }
            res = temp2;
        }
        return res;
    }
}

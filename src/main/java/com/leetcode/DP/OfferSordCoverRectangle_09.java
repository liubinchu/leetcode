package com.leetcode.DP;

/**
 * @author liubi
 * @date 2018-11-27 19:47
 **/
public class OfferSordCoverRectangle_09 {
    /**
     * 算法解析：依旧是动态规划 设 f(n) 为长度为n时的解， 那么 f(n) = f(n-1)*1 + f(n-2)*2 -{f(n-1) 和 f(n-2)重叠的部分}
     * 其中 {f(n-1) 和 f(n-2)重叠的部分} == f(n-2)
     * 那么 dp 公式等于 f(n) = f(n-1)*1 + f(n-2)*1
     * @param int target
     * @return int res
     */
    public int RectCover(int target) {
        int count = target;
        if(count == 1) {
            return 1;
        }
        else if (count == 2){
            return 2;
        }
        else{
            int a =1;
            int b =2;
            int res =0;
            count-=2;
            while(count -- >0){
                res = a+b;
                a=b;
                b=res;
            }
            return res;
        }
    }

    int[] dp ;
    public void dpFun(int n){
        this.dp = new int[n];
        this.dp[0] = 1;
        this.dp[1] = 2;
        for(int i=2;i<n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
    }
    public int RectCover1(int target) {
        if(target<1){
            return 1;
        }
        else if(target==1||target==2){
            return target;
        }
        dpFun(target);
        return this.dp[target-1];
    }

    public static void main(String[] args) {
        OfferSordCoverRectangle_09 solution = new OfferSordCoverRectangle_09();
    }
}

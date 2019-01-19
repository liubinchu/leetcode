package com.leetcode;

public class leetcode_204 {
    // 最朴素的方法超时 注意i<=Math.sqrt(n) 小于等于
    // O(n*sqrt(n))
    /*
    public boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        if(n<=2) return 0;
        int count = 1;
        for(int i=3;i<n;i+=2){
            if(isPrime(i)) count++;
        }
        return count;
    }
    */
    // 看了答案 发现一种更简单的办法 原来的方法 对于每一个<n 的数字 从小到大检查一边是否是prime 检查isPrime时 从小到大再次求余 这两个步骤 都从小到大访问 可以优化
    // 一个bool数组 表示这些数字是否是素数 一开始全部默认是素数 从小到大访问（从2开始）如果是素数 那么其倍数都不是素数 赋值为不是素数。 对于一个元素 访问到它是 他前面的元素的倍数都已经指出（相当于判断出该元素不是素数）。 最后统计是素数的个数
    public int countPrimes(int n){
        if(n<=2) return 0;
        boolean[] notPrimeStat = new boolean[n-2]; // default false
        for(int i=2 ;i<n;i++){
            if(notPrimeStat[i-2] == false){
                for(int j=2;j*i<n;j++){
                    notPrimeStat[j*i-2] = true;
                }
            }
        }
        int count =0;
        for(boolean nPS: notPrimeStat){
            if(nPS == false) count++;
        }
        return count;
    }
    public static void main(String[] args){
        leetcode_204 leetcode204 = new leetcode_204();
        int res = leetcode204.countPrimes(10);
        System.out.println(res);
    }
}

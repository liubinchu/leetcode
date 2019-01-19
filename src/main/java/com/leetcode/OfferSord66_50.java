package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-08 12:34
 **/
public class OfferSord66_50 {
    /**
     * 算法分析：时间 O（3n）空间O（1）
     * 算法思想：见注释
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if(A.length==0){
            return A;
        }
        else {
            //结果数组
            int[] B = new int [A.length];
            // B[i] = A[0]*A[1].......A[i-1] * A[i+1]*......A[n] = A[0]*...*A[n]/A[i]
            // 求 A[0]*A[1].......A[i-1]
            B[0] = 1;
            int formerProduct = B[0];
            int former = A[0];
            for(int i=1;i<A.length;i++){
                B[i] = formerProduct * former;
                former = A[i];
                formerProduct = B[i];
            }
            // 求 A[i+1]*......A[n]
            formerProduct = 1;
            former = A[A.length-1];
            A[A.length-1] = 1;
            for(int i = A.length-2;i>=0;i--){
                int temp = A[i];
                A[i] = formerProduct * former;
                former = temp;
                formerProduct = A[i];
            }
            // 将两部分 相乘
            for(int i =0;i<A.length;i++){
                B[i] *= A[i];
            }
            return B;
        }
    }
    public static void main(String[] args) {
        OfferSord66_50 solution = new OfferSord66_50();
        int[] A = {1,2,3,4,5};
        int[] B = solution.multiply(A);
        for(int num : B){
            System.out.print(num+" ");
        }
    }
}

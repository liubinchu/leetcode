package com.leetcode;

import java.util.Scanner;

/**
 * @author binchu.liu
 * @date 23/08/2019 20:04
 */
public class beike02 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
                int[] quant = new int[n];
        int[] volume = new int[n];
/*        int n = 4;
        int m = 100;
        int[] quant = new int[]{3, 3, 1, 1};
        int[] volume = new int[]{40, 6, 1, 5};*/

        for (int i = 0; i < n; i++) {
            quant[i] = in.nextInt();
            volume[i] = in.nextInt();
        }
        int num = 0;

        for (int i = 0; i < quant.length; i++) {
            int singleNum = m / volume[i];
            if(singleNum<0){
                break;
            }
            singleNum = Math.min(singleNum, quant[i]);
            m -= volume[i] * singleNum;
            num += singleNum;
        }
        System.out.println(num);
    }

}

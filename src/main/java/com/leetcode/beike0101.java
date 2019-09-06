package com.leetcode;

import java.util.*;

/**
 * @author binchu.liu
 * @date 23/08/2019 20:37
 */
public class beike0101 {

    public static int fun(int money, int[] devieces) {
        int num = 0;
        Arrays.sort(devieces);
        for (int i = 0; i < devieces.length; i++) {
            if (money < devieces[i]) {
                break;
            } else {
                money -= devieces[i];
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int money = in.nextInt();
        int[] devieces = new int[n];
        for (int i = 0; i < n; i++) {
            devieces[i] = in.nextInt();
        }
   /*     int money = 10;
        int[] devieces = new int[]{3, 9, 5, 7, 6};*/
        System.out.println(fun(money, devieces));
        HashSet<Integer> h1= new HashSet<>();
        h1.add(1);
    }


    public static void gengoing(String[] args) {
        Scanner in = new Scanner(System.in);
        int typeNum = in.nextInt();
        int Sum = in.nextInt();
        ArrayList<Integer> costArray = new ArrayList<Integer>();
        for (int i = 0; i < typeNum; i++) {
            costArray.add(in.nextInt());
        }
        Collections.sort(costArray);
        int res = 0;
        int trueCost = 0;
        while (trueCost < Sum) {
            res++;
            trueCost += costArray.get(res - 1);
        }
        if (trueCost > Sum)
            res--;
        System.out.println(res);

    }
}


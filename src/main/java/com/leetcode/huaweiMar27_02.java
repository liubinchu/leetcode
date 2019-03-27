package com.leetcode;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class huaweiMar27_02{
    static double[][] arr = new double[6][2];
    static double[][] dis = new double[6][6];
    public static void main(String[] args) {
        double distance = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dis[i][j] = Math.sqrt(Math.abs(arr[i][0] - arr[j][0]) * Math.abs(arr[i][0] - arr[j][0]) + Math.abs(arr[i][1] - arr[j][1]) * Math.abs(arr[i][1] - arr[j][1]));
            }
        }
        LinkedList<Integer> save = new <Integer>LinkedList();
        for(int i=1;i<=5;i++){
            save.add(1);
        }
        distance = method(0, save);
        System.out.println((int) distance);
    }
    public static double method(Integer b, LinkedList<Integer> save) {
        Iterator<Integer> it = save.iterator();
        double max = 10000000;
        if (!it.hasNext()) {
            return 0;
        }
        if (save.size() == 1) {
            Integer i = it.next();
            return dis[0][i] + dis[b][i];
        }
        while (it.hasNext()) {
            Integer a = it.next();
            LinkedList<Integer> save2 = new <Integer>LinkedList();
            save2.addAll(save);
            save2.remove(a);
            Double c = method(a, save2);
            max = max>(dis[b][a] + c)?(dis[b][a] + c):max;
        }
        return max;
    }
}
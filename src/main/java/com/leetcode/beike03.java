package com.leetcode;

import java.util.Scanner;

/**
 * @author binchu.liu
 * @date 23/08/2019 21:01
 */
public class beike03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        String data = in.nextLine();
/*        int n = 3;
        int k = 4;
        String data = "aba";*/
        char[] chars = data.toCharArray();

        int index = data.length();
        for (int i = 1; i < data.length(); i++) {
            String houzhui = data.substring(i);
            String qianzhui = data.substring(0, data.length()-i);
            if (houzhui.equals(qianzhui)) {
                index = i;
                break;
            }
        }
        String appender  = data.substring(0,index);
        StringBuilder res = new StringBuilder(data);
        for(int i=1;i<k;i++){
            res.append(appender);
        }
        System.out.println(res.toString());
        //System.out.println(index);
    }
}

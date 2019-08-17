package com.leetcode;

import java.util.Scanner;

/**
 * @author binchu.liu
 * @date 17/08/2019 14:32
 */
public class Zoom1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        int n = in.nextInt();
        if(data==null||data.equals("")){
            System.out.println("");
        }
        if(n==0){
            System.out.println(data);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append("0");
        }
        System.out.println(data.replace(sb.toString(),""));
    }

/*    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        int target = in.nextInt();
        int start = -1;
        int end = start;

        if (data == null || target <= 0) {
            System.out.println(data);
            return;
        }
        char s[] = data.toCharArray();
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                start = start == -1 ? i : start;
                count++;
            } else {
                if (count == target) {
                    while (count-- != 0) {
                        s[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == target) {
            while (count != 0) {
                count--;
                s[start++] = 0;
            }
        }
        System.out.println(String.valueOf(s));
        return;
    }*/

}

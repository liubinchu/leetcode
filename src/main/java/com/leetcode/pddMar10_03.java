package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author thinking_fioa 10/03/2019
 */
public class pddMar10_03 {

    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        // n家银行 1<=n<=200000
        int n = input.nextInt();
        // d距离 1<= d <=100000000
        long d = input.nextLong();
        List<Back> backList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int a = input.nextInt();
            long b  = input.nextLong();
            backList.add(new Back(a, b));
        }
        solution(backList, n, d);
    }

 public static void main2(String [] args) {
   // n家银行 1<=n<=200000
    int n = 6;
    // d距离 1<= d <=100000000
    long d = 3;

   List<Back> backList = new ArrayList<>();

    backList.add(new Back(1,1));
    backList.add(new Back(3,5));
    backList.add(new Back(4,8));
    backList.add(new Back(6,4));
    backList.add(new Back(10,3));
    backList.add(new Back(11,2));

    solution(backList, n, d);
  }

    public static void solution(List<Back> backList,  int n, long d) {
        long maxPrice = 0L;
        Collections.sort(backList, new CMP());
        for(int i=0, j=0;i<n && j<n;) {
            if(backList.get(i).location - backList.get(j).location >= d) {
                maxPrice = Math.max(maxPrice, backList.get(i).price + backList.get(j).price);
                for(int m = j+1;m<n;m++) {
                    if(backList.get(i).location - backList.get(m).location >= d) {
                        maxPrice = Math.max(maxPrice, backList.get(i).price + backList.get(m).price);
                    }
                }
                i++;
            } else {
                j++;
            }
        }
        System.out.println(maxPrice);
    }


    private static class Back {
        long location;
        long price;
        Back(long location, long price) {
            this.location = location;
            this.price = price;
        }
    }

    public static class CMP implements Comparator {
        @Override
        public int compare(Object arg0, Object arg1) {
            return (int)(((Back)arg1).location - ((Back)arg0).location);
        }
    }
}
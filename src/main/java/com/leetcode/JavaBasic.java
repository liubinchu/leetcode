package com.leetcode;
import java.util.Scanner;
import java.util.*;
public class JavaBasic {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int m = sc.nextInt();
                int n = sc.nextInt();
                if(m == 0 && n == 0) break;
                P[] papers = new P[m];
                for (int i = 0; i < m; i ++ ) {
                    papers[i] = new P(sc.nextDouble(), sc.nextDouble());
                }
                Arrays.sort(papers);
                double sum = 0;
                for (int i = 0; i < papers.length; i ++ ) {
                    if(papers[i].time > n) {
                        sum += n * papers[i].perValue;
                        break;
                    }
                    sum += papers[i].value;
                    n -= papers[i].time;
                }
                System.out.printf("%.2f\n", sum);
            }
        }

        static class P implements Comparable<P> {
            double time;
            double value;
            double perValue;

            public P(double time, double value) {
                this.time = time;
                this.value = value;
                this.perValue = value / time;
            }

            @Override
            public int compareTo(P o) {
                return o.perValue > this.perValue ? 1 : - 1;
            }
    }
}// write your code here
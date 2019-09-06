package com.leetcode;

public class laohu03 {
    int dp(int n) {
        if (n < 0) {
            return 0;
        } else if (n < 2) {
            return 1;
        } else {
            int f1 = 1, f2 = 1;
            for (int i = 2; i <= n; i++) {
                int tmp = f1 + f2;
                f2 = f1;
                f1 = tmp;
            }
            return f1;
        }
    }
}

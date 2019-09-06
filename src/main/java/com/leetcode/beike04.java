package com.leetcode;

/**
 * @author binchu.liu
 * @date 23/08/2019 21:23
 */

import java.util.Scanner;

/**
 * #include <bits/stdc++.h>
 * using namespace std;
 * const int MAXN = 105;
 * const int MAXM = 10005;
 * const int INF = 0x3f3f3f3f;
 *
 * int a[MAXN];
 * int dp[MAXM];
 *
 * int main() {
 *     //freopen("in.txt", "r", stdin);
 *     int n, sum = 0;
 *     scanf("%d", &n);
 *     for (int i = 1; i <= n; i++) {
 *         scanf("%d", &a[i]);
 *         sum += a[i];
 *     }
 *     for (int i = 1; i <= sum; i++)
 *         dp[i] = INF;
 *     dp[0] = 0;
 *     for (int i = 1; i <= n; i++) {
 *         for (int j = sum; j >= a[i]; j--)
 *             dp[j] = min(dp[j], dp[j - a[i]] + 1);
 *     }
 *     int min_x = INF, max_y = 0;
 *     for (int j = 0; j <= sum; j++) {
 *         if (dp[j] < 0) continue;
 *         int x = abs(sum - 2 * j), y = abs(n - 2 * dp[j]);
 *         if (x < min_x) {
 *             min_x = x;
 *             max_y = y;
 *         }
 *         else if (x == min_x) {
 *             max_y = max(max_y, y);
 *         }
 *     }
 *     printf("%d %d\n", min_x, max_y);
 *     return 0;
 * }
 */
public class beike04 {
    public static void main(String[] args) {
        int dp[] = new int[Integer.MAX_VALUE];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int[] data = new int[n+1];
        for(int i=1;i<n;i++){
            data[i] = in.nextInt();
            sum+=data[i];
        }
        for (int i = 1; i <= sum; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= data[i]; j--)
                dp[j] = Math.min(dp[j], dp[j - data[i]] + 1);
        }
        int min_x = Integer.MAX_VALUE, max_y = 0;
        for (int j = 0; j <= sum; j++) {
            if (dp[j] < 0) continue;
            int x = Math.abs(sum - 2 * j), y = Math.abs(n - 2 * dp[j]);
            if (x < min_x) {
                min_x = x;
                max_y = y;
            }
            else if (x == min_x) {
                max_y = Math.max(max_y, y);
            }
        }
        System.out.println(min_x+" "+max_y);

    }
}

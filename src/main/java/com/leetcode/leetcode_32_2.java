package com.leetcode;

/**
 * @author liubi
 * @date 2019-04-30 14:10
 **/
public class leetcode_32_2 {
    /**
     * 时间复杂度 和 空间复杂度 同 使用栈相同
     * leetcode 官网中题解
     * @param s
     * @return
     */
    private int[] dp ;
    // dp[i] 表示当 i==')'时，当前最长括号串的长度， i=='('时，永远为0
    public int longestValidParentheses(String s) {
       this.dp = new int[s.length()];
       int maxLen = Integer.MIN_VALUE;
       for(int i=1;i<s.length();i++){ // 第一个一定不配对
           if (s.charAt(i)==')'){
               if (s.charAt(i-1)=='('){ // 相邻的两个能够配对
                   this.dp[i] = (i>=2?this.dp[i-2]:0) + 2; // 之前的串长度 加上 2
                   if(this.dp[i]>maxLen){maxLen = this.dp[i];}
               }
               else if(i-this.dp[i-1]-1>=0 && s.charAt(i-1)==')' && s.charAt(i-this.dp[i-1]-1)=='('){ //嵌套的括号串
                   this.dp[i] = dp[i-1] + 2 + (i-2-this.dp[i-1]>=0?this.dp[i-2-this.dp[i-1]]:0); // 前一个串的长度 + 2 + 之前串的长度
                   if(this.dp[i]>maxLen){maxLen = this.dp[i];}
               }
           }
       }
       return maxLen;
    }

    public static void main(String[] args) {
        leetcode_32_2 solution = new leetcode_32_2();
        System.out.println(solution.longestValidParentheses(")()())"));
    }
}

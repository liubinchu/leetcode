package com.leetcode;


/**
 * @author liubi
 * @date 2019-04-28 14:12
 **/
public class leetcode_5 {
    String s;
    int resS = -1; // start index of res
    int resE = -2; // end index of res


    /**
     * 动态规划 解法 : 二维动态规划 注意打表的顺序/或者使用递归
     * 时间复杂度 和 空间复杂度 都是 O(n2)
     */
    int[][] dpStatus; // 0 未标记 -1 false 1 true

    private  boolean  dpFunc(int start, int end) {
        if (start == end) {
            return true;
        } else if (start + 1 == end) {
            return this.s.charAt(start) == this.s.charAt(end);
        } else if (start < end) {
            if (dpStatus[start + 1][end - 1] == 0) {
                //throw new Exception("wrong dp order");
                System.out.println("wrong dp order");
            } else {
                return dpStatus[start + 1][end - 1] == 1 && this.s.charAt(start) == this.s.charAt(end);
            }
        } else {
            //throw new Exception("wrong start and end index");
            System.out.println("wrong start and end index");
        }
        return false;
    }

    public String longestPalindromedp(String s) {
        this.s = s;
        this.dpStatus = new int[s.length()][s.length()];
        for (int step = 0; step < s.length(); step++) {
            for (int start = 0; start + step < s.length(); start++) {
                if (dpFunc(start, start + step)) {
                    dpStatus[start][start + step] = 1;
                    if (step > (this.resE - this.resS)) {
                        this.resS = start;
                        this.resE = start + step;
                    }
                } else {
                    dpStatus[start][start + step] = -1;
                }
            }
        }
        if (resS > resE) {
            return "";
        } else {
            return this.s.substring(this.resS, this.resE + 1);
        }
    }

    /**
     * 经观察， 可有中心向外扩散，检查是否是回文串， 时间复杂度O（n2）空间复杂度 O（1）
     * @param start
     * @param end
     * @return
     */
    private Pair<Integer, Integer> extendFromCenter(int start, int end) {
        while (start >= 0 && end < this.s.length() &&
                this.s.charAt(start) == this.s.charAt(end)) {
            start--;
            end++;
        }
        return new Pair<>(++start, --end);
    }

    public String longestPalindrome(String s) {
        this.s = s;
        for (int start = 0; start < this.s.length(); start++) {
            Pair<Integer, Integer> odd = extendFromCenter(start, start);
            Pair<Integer, Integer> even;
            Pair<Integer, Integer> larger;
            if (start + 1 < this.s.length()) {
                even = extendFromCenter(start, start + 1);
                if (odd.getValue() - odd.getKey() < even.getValue() - even.getKey()) {
                    larger = even;
                } else {
                    larger = odd;
                }
            } else {
                larger = odd;
            }
            if (larger.getValue() - larger.getKey() > this.resE - this.resS) {
                this.resS = larger.getKey();
                this.resE = larger.getValue();
            }
        }
        if (this.resS > this.resE) {
            return "";
        } else {
            return this.s.substring(this.resS, this.resE + 1);
        }
    }

    public static void main(String[] args) {
        leetcode_5 solution = new leetcode_5();
        String res = solution.longestPalindrome("babad");
        System.out.println(res);
    }
}

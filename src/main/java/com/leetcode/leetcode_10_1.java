package com.leetcode;

/**
 * @author liubi
 * @date 2019-04-29 18:51
 **/
public class leetcode_10_1 {
    // 正序
    private String s;
    private String p;

    private boolean matchCore(int si, int pi) {
        if (pi >= this.p.length() && si >= this.s.length()) {
            return true;
        } else if (pi >= this.p.length() && si < this.s.length()) {
            return false;
        }
        else if (pi < this.p.length() && si >= this.s.length()) {
            if(pi<=this.p.length()-2 && this.p.charAt(pi+1)=='*'){
                return matchCore(si,pi+2);
            }
            else {
                return false;
            }
        }
        if ((pi < this.p.length() - 1) && this.p.charAt(pi + 1) == '*') {
            if (this.p.charAt(pi) == '.' || this.p.charAt(pi) == this.s.charAt(si)) {
                return matchCore(si + 1, pi + 2) ||
                        matchCore(si + 1, pi) ||
                        matchCore(si, pi + 2);
            } else {
                return matchCore(si, pi + 2);
            }
        } else {
            if (this.p.charAt(pi) == '.' || this.p.charAt(pi) == this.s.charAt(si)) {
                return matchCore(si + 1, pi + 1);
            } else {
                return false;
            }
        }
    }

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return matchCore(0, 0);
    }

    public static void main(String[] args) {
        leetcode_10_1 solusion = new leetcode_10_1();
        System.out.println(solusion.isMatch("", "c*c"));
    }
}

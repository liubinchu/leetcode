package com.leetcode;

/**
 * @author liubi
 * @date 2019-04-29 19:50
 **/
public class leetcode_10_2 {
    private String s;
    private String p;
    private boolean matchCore(int si , int pi){
        if(si>=this.s.length() && pi>=this.p.length()){
            return true;
        }
        else if(si<this.s.length() && pi>=this.p.length()){
            return false;
        }
        else if(si>=this.s.length() && pi<this.p.length()){
            if(this.p.charAt(pi)=='*' && pi<this.p.length()-1){
                return matchCore(si,pi+2);
            }
            else {
                return false;
            }
        }
        if(this.p.charAt(pi)=='*'){
            if(this.p.charAt(pi+1)=='.'||this.p.charAt(pi+1)==this.s.charAt(si)){
                return matchCore(si,pi+2) ||
                        matchCore(si+1,pi+2)||
                        matchCore(si+1,pi);
            }
            else {
                return matchCore(si,pi+2);
            }
        }
        if(this.p.charAt(pi)=='.'||this.p.charAt(pi)==this.s.charAt(si)){
            return matchCore(si+1,pi+1);
        }
        else {
            return false;
        }
    }
    public boolean isMatch(String s, String p) {
        this.s = new StringBuilder(s).reverse().toString();
        this.p = new StringBuilder(p).reverse().toString();
        return matchCore(0,0);
    }
    public static void main(String[] args) {
        leetcode_10_2 solusion = new leetcode_10_2();
        System.out.println(solusion.isMatch("", "c*c*"));
    }
}

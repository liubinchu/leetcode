package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-08 12:35
 **/
public class OfferSord20_52 {
    /**
     * 利用正则表达式 NFA 的思想进行判断
     *
     * @param str
     * @return
     */
    private char[] str;
    private int charIndex;

    public boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        } else {
            this.str = str;
            this.charIndex = 0;
            boolean isNumeric = isInteger();// 整数部分
            if (this.charIndex<this.str.length &&this.str[this.charIndex] == '.') {
                // 小数部分
                this.charIndex++;
                //isNumeric = isNumeric || isUnsignedInteger();  短路特性 when isNumeric is true，  isUnsignedInteger will not carry out
                isNumeric = isUnsignedInteger() || isNumeric;
            }
            if (this.charIndex<this.str.length &&
                    (this.str[this.charIndex] == 'E' || this.str[this.charIndex] == 'e')) {
                // 指数部分
                this.charIndex++;
                isNumeric = isNumeric && isInteger();
            }
            return isNumeric && this.charIndex == this.str.length;
        }
    }
    private boolean isUnsignedInteger() {
        if(this.charIndex>=this.str.length ){
            return false;
        }
        int startIndex = this.charIndex;
        while (this.charIndex < this.str.length && this.str[charIndex] <= '9' && this.str[charIndex] >= '0') {
            this.charIndex++;
        }
        return charIndex > startIndex;
    }

    private boolean isInteger() {
        if (this.charIndex<this.str.length &&
                (this.str[this.charIndex] == '+' || this.str[this.charIndex] == '-')) {
            this.charIndex++;
        }
        return isUnsignedInteger();
    }
    public static void main(String[] args) {
        OfferSord20_52 solution = new OfferSord20_52();
        char[] str = "12e".toCharArray();
        System.out.println(solution.isNumeric(str));
    }
}

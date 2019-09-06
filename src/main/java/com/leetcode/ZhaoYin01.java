package com.leetcode;

public class ZhaoYin01 {
    public class FindString {
        /**
         * 获取模式字符串的Next数组
         */
        private int[] getNextArray(char[] p) {
            int pLen = p.length;
            int[] next = new int[pLen];
            int k = -1;
            int j = 0;
            next[0] = -1;
            while (j < pLen - 1) {
                if (k == -1 || p[j] == p[k]) {
                    k++;
                    j++;
                    next[j] = k;
                } else {
                    k = next[k];
                }
            }
            return next;
        }


        /**
         * 在原字符串中查找模式字符串位置
         * 若存在，则返回第一次出现的位置
         * 若不存在，则返回-1
         */
        public int findStrPos(String sourceStr, String patternStr) {
            int i = 0, j = 0;
            char[] source = sourceStr.toCharArray();
            char[] pattern = patternStr.toCharArray();
            int sLen = source.length, pLen = pattern.length;
            int[] next = getNextArray(pattern);
            while (i < sLen && j < pLen) {
                if (sourceStr.charAt(i) == patternStr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            if (j == pLen)
                return i - j;
            return -1;
        }
    }




}

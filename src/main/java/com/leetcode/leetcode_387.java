package com.leetcode;

public class leetcode_387 {
    // 方法一 很直观 两次搜索 两个循环 O n2 的复杂度
//    public int firstUniqChar(String s) {
//        int n = s.length();
//        for(int i = 0; i< n;i++){
//            char curr = s.charAt(i);
//            boolean flag = false;
//            for( int j = 0 ;j< n ;j++){
//                if((s.charAt(j)==curr)&&(j!=i)){
//                    flag = true; // i 对应的字符 存在 重复字符
//                    break;
//                }
//            }
//            if ((flag == false)) return i;
//        }
//        return -1;
//    }

    // 方法二： 因为字符是有限的 因此 可以 通过构建 hash table 来判断
    // 因此 拿到题目 先分析 输入数据的特点 是一个重要的点
    // 建一个二维数组 index 省略 默认是 a-z 第一行是 字母出现个数 第二行是 字母最后一次出现的次数
    public int firstUniqChar(String s) {
        int[][] hashTable = new int[26][2];
        int n = s.length();
        for(int i = 0; i<n;i++){
            hashTable[s.charAt(i)-'a'][0]++;
            hashTable[s.charAt(i)-'a'][1] = i;
        }
        int index =-1;
        for(int i = 0 ; i<26 ;i++){
            if((hashTable[i][0] == 1)){
                if(index == -1 ) index = hashTable[i][1];
                else if(hashTable[i][1] <index) index = hashTable[i][1];
            }
        }
        return index;
    }
}

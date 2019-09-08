package com.leetcode.BitOperation;

import java.util.Arrays;

/**
 * @author liubi
 * @date 2018-11-27 19:19
 **/
public class OfferSordSuperJumpFloor_08 {
    /**
     * 算法分析： 仍然是简单的动态规划问题 经过分析 发现结果 可以表示成2的幂次方的形式
     *
     * @return
     */
    public int JumpFloorII(int target) {
        int count = target;
        int res = 1;
        while (--count > 0) {
            res = res << 1;
        }
        return res;
    }
    static class father{
        public void f1(){
            System.out.println("f1");
        }

        public father() {
        }
    }
    static class son extends father{
        public void f1(){
            System.out.println("son f1");
        }
        public void f2(){
            System.out.println("f2");
        }

        public son() {
        }
    }



    public static void main(String[] args) {
        System.out.println(Math.floor(-1.6));
        System.out.println(Math.ceil(-1.6));
    }
}

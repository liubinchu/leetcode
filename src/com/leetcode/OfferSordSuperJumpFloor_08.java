package com.leetcode;

/**
 * @author liubi
 * @date 2018-11-27 19:19
 **/
public class OfferSordSuperJumpFloor_08 {
    /**
     *算法分析： 仍然是简单的动态规划问题 经过分析 发现结果 可以表示成2的幂次方的形式
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int count = target;
        int res = 1;
        while(--count > 0){
            res = res << 1;
        }
        return res;
    }
    public static void main(String[] args) {
        OfferSordSuperJumpFloor_08 solution = new OfferSordSuperJumpFloor_08();
    }
}

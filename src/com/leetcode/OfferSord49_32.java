package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2018-12-17 15:48
 **/
public class OfferSord49_32 {
    /**
     * 解题思路：
     * 解法一： 首先的想法是 依次判断0，1，2，3.。。。这些数是不是丑数
     * 解法二： 上述过程依次的判断0，1，2，3.。。。 是否为丑数 对于不是丑数的数字 进行了冗余计算， 如果有算法能够生成下一个丑数 那么能够减少时间复杂度
     * 假设 当前已经获得升序丑数序列， 那么下一个丑数一定是当前序列的数字 通过*2/3/5 的到的 并且是其中的最小值， 且要大于当前升序序列中的最大值。
     */
    private Queue<Integer> uglyNumbers = new PriorityQueue<>();
    public int GetUglyNumber_Solution(int index) {
        this.uglyNumbers.offer(1);
        Integer counter = 1;
        Integer maxUglyNumber = 1;
        Integer nextUglyNumber= Integer.MAX_VALUE;
        switch (index){
            case 0:
                return -1;
            case 1:
                return 1;
            default:
        }
        Iterator<Integer> it ;
        while (counter<index){
            nextUglyNumber = Integer.MAX_VALUE;
            it = this.uglyNumbers.iterator();
            while (it.hasNext()){
                Integer current  = it.next();
                Integer t2 = current *2;
                if(t2>maxUglyNumber && t2<nextUglyNumber){
                    nextUglyNumber = t2;
                    break;
                }
                else if(t2>nextUglyNumber){
                    break;
                }
            }
            it = this.uglyNumbers.iterator();
            while (it.hasNext()){
                Integer current  = it.next();
                Integer t3 = current *3;
                if(t3>maxUglyNumber && t3<nextUglyNumber){
                    nextUglyNumber = t3;
                    break;
                }
                else if(t3>nextUglyNumber){
                    break;
                }
            }
            it = this.uglyNumbers.iterator();
            while (it.hasNext()){
                Integer current  = it.next();
                Integer t5 = current *5;
                if(t5>maxUglyNumber && t5<nextUglyNumber){
                    nextUglyNumber = t5;
                    break;
                }
                else if(t5>=nextUglyNumber){
                    break;
                }
            }
            this.uglyNumbers.offer(nextUglyNumber);
            maxUglyNumber = nextUglyNumber;
            counter++;
        }
        return nextUglyNumber;
    }
    public static void main(String[] args) {
        OfferSord49_32 solution = new OfferSord49_32();
        System.out.println(solution.GetUglyNumber_Solution(100));
        System.out.println(solution.uglyNumbers);
    }
}

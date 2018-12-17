package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2018-12-17 15:48
 **/
public class OfferSord49_32 {
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
                else if(t5>nextUglyNumber){
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

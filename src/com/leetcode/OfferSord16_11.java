package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubi
 * @date 2018-11-27 21:28
 **/
public class OfferSord16_11 {
    /**
     * 算法分析 ： 分治法 可以划分为重复的子问题 打表计算结果
     */
    private Map<Integer,Double> res= new HashMap<>();
    private double PowerCal(double base, int exponent){
        Double power = res.get(exponent);

        if(power == null){
            if((exponent&1)==1){
                power = PowerCal(base,exponent-1)*base;
                res.put(exponent-1,power);
            }
            else{
                power = PowerCal(base,exponent/2);
                power *= power;
                res.put(exponent,power);
            }
        }
        return power;
    }
    public double Power(double base, int exponent){
        res.put(1,base);
        res.put(0,1.0);
        res.put(-1,1/base);
        return PowerCal(base,exponent);
    }
    public static void main(String[] args) {
        OfferSord16_11 solution = new OfferSord16_11();
        solution.Power(2,3);
    }
}

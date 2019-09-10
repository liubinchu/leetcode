package com.leetcode.RememberSearch;

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
    private Map<Integer, Double> res = new HashMap<>();

    private double PowerCal(double base, int exponent) {
        Double power = res.get(exponent);
        if (power == null) {
            if ((exponent & 1) == 1) {
                power = PowerCal(base, exponent - 1) * base;
                res.put(exponent - 1, power);
            } else {
                power = PowerCal(base, exponent >> 1);
                power *= power;
                res.put(exponent, power);
            }
        }
        return power;
    }

    public double Power(double base, int exponent) {
        res.put(1, base);
        // 递归边界 正数
        res.put(0, 1.0);
        // 递归边界 exponent ==0
        res.put(-1, 1 / base);
        // 递归边界 负数情况

        // 考虑问题 要全面
        // 0的正数次方 永远为0， 0的负数次方错误情况 数学上不成立 次数直接返回0 面试时可以向面试官说明
        if (base == 0) {
            return 0;
        } else {
            //base 不是0
            return PowerCal(base, exponent);
        }
    }

    HashMap<Integer, Double> rememberSet;

    public double powCore(double base, int exponent) {
        double res ;
        if (rememberSet.containsKey(exponent)) {
            res = this.rememberSet.get(exponent);
        } else if ((exponent&1)==0){
            double half = powCore(base,exponent>>1);
            res = half*half;
            this.rememberSet.put(exponent,res);
        }else {
            double less = powCore(base,exponent-1);
            res =  less*base;
            this.rememberSet.put(exponent,res);
        }
        return res;
    }

    public double Power1(double base, int exponent) {
        this.rememberSet = new HashMap<>();
        this.rememberSet.put(0, 1d);
        this.rememberSet.put(1, base);
        this.rememberSet.put(-1, 1/base);
        return powCore(base,exponent);
    }

    public static void main(String[] args) {
        OfferSord16_11 solution = new OfferSord16_11();
        System.out.println(solution.Power(2, -3));
    }
}

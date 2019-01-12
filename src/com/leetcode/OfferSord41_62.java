package com.leetcode;

import java.util.LinkedList;

/**
 * @author liubi
 * @date 2019-01-12 19:18
 **/
public class OfferSord41_62 {
    private LinkedList<Integer> numbers; // ascent order

    public void Insert(Integer num) {
        if(this.numbers == null){
            this.numbers = new LinkedList<>();
            this.numbers.add(num);
        }
        else {
            int index = 0;
            while (index<this.numbers.size()&&this.numbers.get(index)<num){
                index++;
            }
            this.numbers.add(index,num);
        }
    }

    public Double GetMedian() {
        Double result;
        int length = this.numbers.size();
        if(length%2==0){
            result = (this.numbers.get(length/2).doubleValue() + this.numbers.get(length/2-1).doubleValue())/2;
        }
        else {
            result = this.numbers.get(length/2).doubleValue();
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSord41_62 solution = new OfferSord41_62();
    }
}

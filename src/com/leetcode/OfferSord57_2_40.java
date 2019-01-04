package com.leetcode;

import java.util.ArrayList;

/**
 * @author liubi
 * @date 2019-01-04 09:37
 **/
public class OfferSord57_2_40 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(int i = sum; i>1;i--){
            int residue = sum *2  - i*i +i;
            if(residue>0){
                if(residue%(2*i) == 0){
                    int start = residue/2/i;
                    ArrayList<Integer> continuousSequence = new ArrayList<>();
                    for(int j = 0;j<i;j++){
                        continuousSequence.add(j+start);
                    }
                    result.add(continuousSequence);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSord57_2_40 solution = new OfferSord57_2_40();
        System.out.println(solution.FindContinuousSequence(3));
    }
}

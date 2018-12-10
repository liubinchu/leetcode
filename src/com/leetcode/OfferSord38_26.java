package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2018-12-10 09:42
 **/
public class OfferSord38_26 {
    private <T> void  arrangement(Set<T> dataSet ,List<T> arrangement, int selectNum,Set<List<T>> result) throws Exception {
        if(arrangement.size()> selectNum){
            throw new Exception("compute error");
        }
        else if(selectNum == 0){
            return;
        }
        else if(arrangement.size()==selectNum){
            result.add(arrangement);
        }
        else {
            for(T element : dataSet){
                if(!arrangement.contains(element)){
                    List<T> arrangementCopy = new ArrayList<>(arrangement);
                    arrangementCopy.add(element);
                    arrangement(dataSet,arrangementCopy,selectNum,result);
                }
            }
        }
    }

    private  void addElement(Set<Integer> dataSet,Integer element , int cycle){
        if(dataSet.contains(element)){
            addElement(dataSet,element+ cycle,cycle);
        }
        else {
            dataSet.add(element);
        }
    }
    public ArrayList<String> Permutation(String str) throws Exception {
        Set<Integer> dataSet=  new HashSet<>();
        for(Character c : str.toCharArray()){
            addElement(dataSet,(int)c,26);
        }
        Set<List<Integer>> result = new HashSet<>();
        arrangement(dataSet, new ArrayList<>(),dataSet.size(),result);
        ArrayList<String> res = new ArrayList<>();
        for(List<Integer> element : result){
            StringBuilder stringBuilder = new StringBuilder();
            for(int c : element){
                stringBuilder.append((char)(c%26+78));
            }
            String arrangement = stringBuilder.toString();
            if(!res.contains(arrangement)){
                res.add(arrangement);
            }
        }
        Collections.sort(res);
        System.out.println(res);
        return  res;
    }


    public static void main(String[] args) throws Exception {
        OfferSord38_26 solution = new OfferSord38_26();
        solution.Permutation("aa");
    }
}

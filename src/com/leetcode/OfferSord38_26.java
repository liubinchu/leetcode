package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2018-12-10 09:42
 **/
public class OfferSord38_26 {
    /**
     * dataset中元素可以重复
     * @param dataSet
     * @param arrangement
     * @param selectNum
     * @param result
     * @param index
     * @param <T>
     * @throws Exception
     */

    private <T> void  arrangement(LinkedList<T> dataSet ,List<T> arrangement, int selectNum,Set<List<T>> result) throws Exception {
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
                List<T> arrangementCopy = new ArrayList<>(arrangement);
                arrangementCopy.add(element);
                LinkedList<T> dataSetCopy = new LinkedList<>(dataSet);
                dataSetCopy.remove(element);
                arrangement(dataSetCopy,arrangementCopy,selectNum,result);
            }
        }
    }

    public ArrayList<String> Permutation(String str) throws Exception {
        LinkedList<Character> dataSet=  new LinkedList<>();
        for(Character c : str.toCharArray()){
            dataSet.add(c);
        }
        Set<List<Character>> result = new HashSet<>();
        arrangement(dataSet,new ArrayList<>(),dataSet.size(),result);
        ArrayList<String> res = new ArrayList<>();
        for(List<Character> element : result){
            StringBuilder stringBuilder = new StringBuilder();
            for(Character c : element){
                stringBuilder.append(c);
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
        solution.Permutation("aab");
    }
}

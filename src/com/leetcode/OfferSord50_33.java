package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2018-12-18 16:37
 **/
public class OfferSord50_33 {
    /**
     * 算法分析：利用一个map 空间换时间 注意：具体采用的是linkedHashMap 该实现的entrySet 默认是有序的（加入时的顺序），如果使用HashMap实现 那么则不是，需要另外确定字符在string中的顺序
     */
    private Map<Character,Integer> location = new LinkedHashMap<>();
    public int FirstNotRepeatingChar(String str) {
        Character c = null;
        for(int i =0;i<str.length();i++){
            c = str.charAt(i);
            if(!this.location.containsKey(c)){
                this.location.put(c,i);
            }
            else {
                this.location.put(c,-1);
            }
        }
        Integer result = -1;
        for(Map.Entry entry : this.location.entrySet()){
            Integer value = (Integer)entry.getValue();
            if(value!=-1){
                result = value;
                break;
            }
        }
        print(this.location.entrySet());
        return result;
    }
    public static void print(Object o){
        System.out.println(o.toString());
    }
    public static void main(String[] args) {
        OfferSord50_33 solution = new OfferSord50_33();
        print(solution.FirstNotRepeatingChar("wertgyhujoestdrytyhuii"));
    }
}

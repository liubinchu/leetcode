package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liubi
 * @date 2019-01-09 20:26
 **/
public class OfferSordFirstAppearingOnce_53 {
    private StringBuilder stringBuilder = new StringBuilder();
    private Map<Character,Integer> appearanceCounter = new HashMap();
    /**
     * Insert one char from stringstream
     * @param ch
     */
    public void Insert(char ch)
    {
        this.stringBuilder.append(ch);
        if(this.appearanceCounter.containsKey(ch)){
            this.appearanceCounter.put(ch,this.appearanceCounter.get(ch)+1);
        }
        else {
            this.appearanceCounter.put(ch,1);
        }
    }
    /**
     * return the first appearence once char in current stringstream\
     * @return
     */
    public char FirstAppearingOnce()
    {
        Character result = '#';
        // stringBuilder 中 index 的顺序是反的， index==0 时 位置指向 stringBuilder 的最后一个/最近加入的元素
        for(int i=this.stringBuilder.length()-1 ;i>=0;i--){
            if (this.appearanceCounter.get(this.stringBuilder.charAt(i))==1){
                result = this.stringBuilder.charAt(i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        OfferSordFirstAppearingOnce_53 solution = new OfferSordFirstAppearingOnce_53();
        String s = "google";
        for(Character character : s.toCharArray()){
            System.out.print("char:   "+character);
            solution.Insert(character);
            System.out.println("    FirstAppearingOnce:     "+solution.FirstAppearingOnce()+"   stringBuilder   "+solution.stringBuilder);
        }
    }
}

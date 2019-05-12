package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-05-12 14:05
 * 根据 string中具有的26个字母的个数 作为key
 * Time Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
 * Space Complexity: O(NK)O(NK), the total information content stored in ans.
 **/
public class leetcode_49_2 {
    private String keyGen(String string){
        int[] keyArray = new int[26];
        for(char c :string.toCharArray()){
            keyArray[c-'a']++;
        }
        StringBuilder keySB = new StringBuilder();
        for(int keyElement: keyArray){
            keySB.append(keyElement);
            keySB.append(",");
        }
        return keySB.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String string : strs){
            String key = keyGen(string);
            if(!map.keySet().contains(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        leetcode_49_2 solution = new leetcode_49_2();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strings));
    }
}

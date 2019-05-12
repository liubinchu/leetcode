package com.leetcode;

import java.util.*;

/**
 * @author liubi
 * @date 2019-05-12 13:22
 * 根据 sorted string 作为key
 * Time Complexity: O(NK \log K)O(NKlogK), where NN is the length of strs, and KK is the maximum length of a string in strs. The outer loop has complexity O(N)O(N) as we iterate through each string. Then, we sort each string in O(K \log K)O(KlogK) time.
 * Space Complexity: O(NK)O(NK), the total information content stored in ans.
 **/
public class leetcode_49_1 {
    private String getKey(String string){
        char[] keyArray = string.toCharArray();
        Arrays.sort(keyArray);
        return String.valueOf(keyArray);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String string: strs){
            String key = getKey(string);
            if(!map.keySet().contains(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        int [] array = {1,2,3};
        leetcode_49_1 solution = new leetcode_49_1();
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution.groupAnagrams(strings));
    }
}

package com.leetcode;

public class leetcode_125 {
    public boolean isPalindrome(String s) {
        int i =0;
        int j = s.length()-1;
        char char_i;
        char char_j;
        while(i<j){
            if((s.charAt(i)<='z')&&(s.charAt(i)>='a')){
                char_i = s.charAt(i);
            }
            else if((s.charAt(i)<='Z')&&(s.charAt(i)>='A')){
                char_i = Character.toLowerCase(s.charAt(i));
            }
            else if((s.charAt(i)<= '9')&&(s.charAt(i)>='0')){
                char_i = s.charAt(i);
            }
            else {
                i++;
                continue;
            }
            if((s.charAt(j)<='z')&&(s.charAt(j)>='a')){
                char_j = s.charAt(j);
            }
            else if((s.charAt(j)<='Z')&&(s.charAt(j)>='A')){
                char_j = Character.toLowerCase(s.charAt(j));
            }
            else if((s.charAt(j)<= '9')&&(s.charAt(j)>='0')){
                char_j = s.charAt(j);
            }
            else {
                j--;
                continue;
            }

            if(char_i != char_j){
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}

package com.leetcode;

        import java.util.HashSet;
        import java.util.Scanner;
        import java.util.Set;

public class tongcheng58_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        Set<String> set = new HashSet<>();
        for(String d : data.split(",")){
            set.add(d);
        }
        System.out.println(set.size());
    }
}

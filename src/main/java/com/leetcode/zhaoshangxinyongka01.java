package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author liubi
 * @date 2019-03-17 19:50
 **/
public class zhaoshangxinyongka01 {
    static class Pair<K,V> {
        private K key;
        public K getKey() {
            return key;
        }
        private V value;
        public V getValue() {
            return value;
        }
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    static class MyPairComparator implements Comparator {
        /**
         * 整数比较器，将整数按降序排列
         * o1比o2大，返回-1；o1比o2小，返回1。
         */
        @Override
        public int compare(Object o1, Object o2) {

            int i1 = ((Pair<Integer, Integer>) o1).getKey();
            int i2 = ((Pair<Integer, Integer>) o2).getKey();
            if (i1 < i2) {
                return -1;
            }
            if (i1 > i2) {
                return 1;
            }
            return 0;
        }
    }
    public static boolean isStable(ArrayList<Pair<Integer, Integer>> data){
        // data is sored
        if(data.size()==1){
            return true;
        }
        else {
            int n = data.size()/2 + 1;
            int last = data.get(data.size()-1).getKey();
            for(int i=data.size()-1;i>data.size()-n-1;i--){
                if(last!=data.get(i).getKey()){
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        ArrayList<Pair<Integer, Integer>> data = new ArrayList<>();
        int n = -1;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            n = in.nextInt();
            int[] l = new int[n];
            int[] d = new int[n];
            for(int i=0;i<n;i++){
                l[i] = in.nextInt();
            }
            for(int i=0;i<n;i++){
                d[i] = in.nextInt();
            }
/*            n = 5;
            int[] l = {5,6,7,7,9};
            int[] d = {2,3,4,5,6};*/
            for (int i = 0; i < n; i++) {
                data.add(new Pair<>(l[i], d[i]));
            }
            data.sort(new MyPairComparator());
            int cost = 0;
            while(!isStable(data)){
                cost+= data.get(0).getValue();
                data.remove(data.size()-1);
            }
            System.out.println(cost);
            break;
        }
    }
}


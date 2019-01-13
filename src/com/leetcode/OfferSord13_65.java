package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liubi
 * @date 2019-01-12 21:53
 **/

class Pair<K,V>{
    private K key;
    public K getKey() { return key; }
    private V value;
    public V getValue() { return value; }
    public Pair(K key,V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (key != null ? key.hashCode() : 0);
        hash = 31 * hash + (value != null ? value.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (key != null ? !key.equals(pair.key) : pair.key != null) {
                return false;
            }
            return value != null ? value.equals(pair.value) : pair.value == null;
        }
        return false;
    }
}
public class OfferSord13_65 {
    /**
     * 算法分析：递归法
     * nowcoder OJ 没有javaFX pair 的package 这里将pair 代码 赋值到本地
     */
    private Set<Pair<Integer,Integer>> positions;
    private Integer threshold;
    private Integer cols;
    private Integer rows;

    private boolean isLeagalPos(Pair<Integer,Integer> pos){
        int x = pos.getKey();
        int y = pos.getValue();
        if(x>=0&&x<this.cols && y>=0 && y<this.rows){
            int sum = 0;
            while(x!=0){
                sum += x%10;
                x /= 10;
            }
            while (y!=0){
                sum += y%10;
                y /= 10;
            }
            return sum <= threshold;
        }
        return false;
    }
    private void movingCore(Pair<Integer,Integer> pos){
        if(!this.positions.contains(pos)&&isLeagalPos(pos)) {
            this.positions.add(pos);
            ArrayList<Pair<Integer,Integer>> positions = new ArrayList<>();
            positions.add(new Pair<>(pos.getKey()+1,pos.getValue()));
            positions.add(new Pair<>(pos.getKey()-1,pos.getValue()));
            positions.add(new Pair<>(pos.getKey(),pos.getValue()+1));
            positions.add(new Pair<>(pos.getKey(),pos.getValue()-1));
            for(Pair<Integer,Integer> nextPos :positions){
                movingCore(nextPos);
            }
        }
    }
    public int movingCount(int threshold, int rows, int cols)
    {
        this.positions = new HashSet<>();
        this.threshold = threshold;
        this.cols = cols;
        this.rows = rows;

        Pair<Integer,Integer> startPos = new Pair<>(0,0);
        movingCore(startPos);
        return this.positions.size();
    }
    public static void main(String[] args) {
        OfferSord13_65 solution = new OfferSord13_65();
        int result = solution.movingCount(18,100,100);
        System.out.println(result);
    }
}

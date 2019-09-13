package com.leetcode.Loop;


import java.util.ArrayList;
import java.util.List;


public class leetcode_12 {
    class Pair<K, V> {
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
                if (key != null ? !key.equals(pair.getKey()) : pair.getKey() != null) {
                    return false;
                }
                return value != null ? value.equals(pair.getValue()) : pair.getValue() == null;
            }
            return false;
        }
    }

    public String intToRoman(int num) {
        List<Pair> listMap = new ArrayList<>(13);
        listMap.add(new Pair(1000, "M"));
        listMap.add(new Pair(900, "CM"));
        listMap.add(new Pair(500, "D"));
        listMap.add(new Pair(400, "CD"));
        listMap.add(new Pair(100, "C"));
        listMap.add(new Pair(90, "XC"));
        listMap.add(new Pair(50, "L"));
        listMap.add(new Pair(40, "XL"));
        listMap.add(new Pair(10, "X"));
        listMap.add(new Pair(9, "IX"));
        listMap.add(new Pair(5, "V"));
        listMap.add(new Pair(4, "IV"));
        listMap.add(new Pair(1, "I"));
        StringBuilder res = new StringBuilder();
        for (Pair<Integer, String> entry : listMap) {
            while (num >= entry.getKey()) {
                num -= entry.getKey();
                res.append(entry.getValue());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        leetcode_12 so = new leetcode_12();
        System.out.println(so.intToRoman(3));
    }
}

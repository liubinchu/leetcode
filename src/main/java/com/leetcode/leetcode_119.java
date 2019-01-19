package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        if (rowIndex == 0) return pre;
        for(int i = 1 ; i<rowIndex+1 ;i++){
            List<Integer> current = new ArrayList<Integer>();

            current.add(1);
            for(int j=1; j<i; j++){
                current.add(pre.get(j-1)+pre.get(j));
            }
            current.add(1);

            pre = current;
        }
        return pre;
    }
}

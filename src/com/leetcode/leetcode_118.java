package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> pre = new ArrayList<Integer>();
        if(numRows == 0) {
            //res.add(pre);
            return res;
        }
        else {
            pre.add(1);
            res.add(pre);
            for (int i = 1 ; i<numRows; i++){
                List<Integer> current = new ArrayList<Integer>();
                for (int j = 0 ; j<i+1;j++){
                    if(j == 0 ) current.add(1);
                    else if( j<i ) current.add(pre.get(j-1)+pre.get(j));
                    else if (j == i) current.add(1);
                }
                res.add(current);
                pre = current;
            }
            return res;
        }

    }
}

package com.leetcode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author liubi
 */
public class OfferSword01 {
    public static void main(String[] args) {
        label:
        for (int i =0; i<100;i++){
            for (int j=0;j<10;j++){
                if(j==5) continue label;
                if(j==9) break label;
                System.out.println(i*j);
            }
        }
        TreeNode treeNode = new TreeNode(1);

    }
}

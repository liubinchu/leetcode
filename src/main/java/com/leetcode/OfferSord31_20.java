package com.leetcode;

import java.util.Stack;

/**
 * @author liubi
 * @date 2018-11-30 13:18
 **/
public class OfferSord31_20 {
    /**
     * 算法分析： T O(n2) S O(1)
     * 经过分析 popA 中的元素 只能出现在 pushA 元素 第一个已出栈元素之前一个位置 或者 第一个已出栈元素之后
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length != popA.length) {
            return false;
        } else if (pushA.length == 0) {
            return true;
        } else {
            // init pre and post index in pushA;
            int pre = -1;
            int popIndex = 0;
            for (int i = 0; i < pushA.length; i++) {
                if (pushA[i] == popA[popIndex]) {
                    pre = i;
                    break;
                }
            }
            popIndex = 1;
            if (pre == -1) {
                return false; // 第一个要出栈的元素 不在入栈队列中
            } else {
                while (popIndex < popA.length) {
                    boolean finded = false;
                    if(pre>0 && pushA[pre-1]==popA[popIndex]){
                        pre--;
                        finded = true;
                    }
                    for(int i = pre;i<pushA.length;i++){
                        if(pushA[i]==popA[popIndex]){
                            finded = true;
                            break;
                        }
                    }
                    popIndex++;
                    if(!finded) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    /**
     * 算法分析： 利用栈进行模拟 T：O（n） S：O（n）
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder_1(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int pushIndex = 0;
        for (int popIndex = 0; popIndex < popA.length; popIndex++) {
            while (stack.empty() || stack.peek() != popA[popIndex]) {
                if (pushIndex >= pushA.length) {
                    return false; // 如果要弹出的元素 不在栈顶，（while中满足） 且 不在未入栈数组中 那么 顺序有错
                } else {
                    stack.push(pushA[pushIndex++]);
                }
            }
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        OfferSord31_20 solution = new OfferSord31_20();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4,5,3,2,1};
        System.out.println(solution.IsPopOrder(pushA, popA));
    }
}

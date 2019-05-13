package com.leetcode;

import java.util.LinkedList;


/**
 * @author liubi
 * @date 2019-05-13 16:24
 * 输入为 逆波兰表达式
 * return 对应计算值
 **/
public class leetcode_150 {
    private Pair<Boolean, Integer> parseToken(String token) {
        Pair<Boolean, Integer> res = null;
        if (token == null || token.length() == 0) {
            res = new Pair<>(false, 6);
        } else {
            char first = token.charAt(0);
            if (token.length() == 1 && first == '+') {
                res =  new Pair<>(false, 0);
            } else if (token.length() == 1 && first == '-') {
                res =  new Pair<>(false, 1);
            } else if (token.length() == 1 && first == '*') {
                res =  new Pair<>(false, 2);
            } else if (token.length() == 1 && first == '/') {
                res =  new Pair<>(false, 3);
            } else if (token.length() == 1 && first == '(') {
                res =  new Pair<>(false, 4);
            } else if (token.length() == 1 && first == ')') {
                res =  new Pair<>(false, 5);
            }
            else {
                try {
                    res =  new Pair<>(true, Integer.parseInt(token));
                } catch (Exception e) {
                    res = new Pair<>(false, 6);
                }
            }
        }
        return res;
    }
    private int cal(LinkedList<Integer> stack,Pair<Boolean, Integer> token) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (token.getValue()) {
            case 0:
                return (num1 + num2);
            case 1:
                return (num1 - num2);
            case 2:
                return (num1 * num2);
            case 3:
                return (num1 / num2);
            default:
                System.out.println("error");
                return Integer.MAX_VALUE;
        }
    }
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> numStack = new LinkedList<>();
        for(String tokenString : tokens){
            Pair<Boolean, Integer> token = parseToken(tokenString);
            if (token.getKey()){
                numStack.push(token.getValue());
            }
            else {
                numStack.push(cal(numStack,token));
            }
        }
        return numStack.peek();
    }
    public static void main(String[] args) {
        leetcode_150 solution = new leetcode_150();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(tokens));
    }
}

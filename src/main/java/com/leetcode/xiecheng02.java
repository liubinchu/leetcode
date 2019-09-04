package com.leetcode;

/**
 * @author liubi
 * @date 2019-09-04 19:52
 **/

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class xiecheng02 {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {
        Stack<Character> stack = new Stack<>();
        char[] data = expr.toCharArray();
        for(char d:data){
            if(d!=')'){
                stack.push(d);
            }else {
                List<Character> temp = new LinkedList<>();
                while (stack.peek()!='('){
                    if(stack.empty()){return ""; }
                    temp.add(stack.pop());
                }
                if(stack.peek()=='('){ stack.pop();}
                for(Character c: temp){
                    stack.push(c);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i=0;i<stack.size();i++){
            res.append(stack.get(i));
        }
        return res.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}


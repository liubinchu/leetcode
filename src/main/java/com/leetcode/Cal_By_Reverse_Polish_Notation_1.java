package com.leetcode;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author liubi
 * @date 2019-05-13 15:47
 * 不得到逆波兰表达式，直接得到结果：在运算符进入逆波兰表达式时，计算结果
 **/
public class Cal_By_Reverse_Polish_Notation_1 {
    private int[][] op = new int[6][6]; // +-*/() 的index为012345， op[2][3] 表示当前元素*（2）和栈顶元素/（3）的大小关系为< (-1)
    private LinkedList<Pair<Boolean, Integer>> RPRStack = new LinkedList<>(); // 逆波兰表达式栈
    private LinkedList<Pair<Boolean, Integer>> opaStack = new LinkedList<>(); // 运算栈

    {
        op[0][0] = -1;
        op[0][1] = -1;
        op[0][2] = -1;
        op[0][3] = -1;
        op[0][4] = 1;
        op[0][5] = 0;
        op[1][0] = -1;
        op[1][1] = -1;
        op[1][2] = -1;
        op[1][3] = -1;
        op[1][4] = 1;
        op[1][5] = 0;
        op[2][0] = 1;
        op[2][1] = 1;
        op[2][2] = -1;
        op[2][3] = -1;
        op[2][4] = 1;
        op[2][5] = 0;
        op[3][0] = 1;
        op[3][1] = 1;
        op[3][2] = -1;
        op[3][3] = -1;
        op[3][4] = 1;
        op[3][5] = 0;
        op[4][0] = 1;
        op[4][1] = 1;
        op[4][2] = 1;
        op[4][3] = 1;
        op[4][4] = 1;
        op[4][5] = 0;
        op[5][0] = -1;
        op[5][1] = -1;
        op[5][2] = -1;
        op[5][3] = -1;
        op[5][4] = -1;
        op[5][5] = 0;
    }

    /**
     * @param token
     * @return Pair<true, Integer> if a number; Pair<false,Integer> if a operator +-* /() 的index为012345
     */
    private Pair<Boolean, Integer> parseToken(String token) {
        if (token == null || token.length() == 0) {
            return new Pair<>(false, 6);
        } else {
            char first = token.charAt(0);
            if (first == '+') {
                return new Pair<>(false, 0);
            } else if (first == '-') {
                return new Pair<>(false, 1);
            } else if (first == '*') {
                return new Pair<>(false, 2);
            } else if (first == '/') {
                return new Pair<>(false, 3);
            } else if (first == '(') {
                return new Pair<>(false, 4);
            } else if (first == ')') {
                return new Pair<>(false, 5);
            } else {
                try {
                    return new Pair<>(true, Integer.parseInt(token));
                } catch (Exception e) {
                    return new Pair<>(false, 6);
                }
            }
        }
    }

    private int cal(Pair<Boolean, Integer> token) {
        int num2 = RPRStack.pop().getValue();
        int num1 = RPRStack.pop().getValue();
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
        for (String tokenString : tokens) {
            Pair<Boolean, Integer> token = parseToken(tokenString);
            if (token.getKey()) {
                // num
                RPRStack.push(token);
            } else {
                // operator
                while (!opaStack.isEmpty() && op[token.getValue()][opaStack.peek().getValue()] == -1) { // 0 illegal 没写
                    Pair<Boolean, Integer> top = opaStack.pop();
                    if (top.getValue() != 4 && top.getValue() != 5) {
                        RPRStack.push(new Pair<>(true, cal(top))); //在运算符进入逆波兰表达式时，计算结果
                    }
                }
                if (token.getValue() != 5) {
                    opaStack.push(token);
                }
            }
        }
        ListIterator<Pair<Boolean, Integer>> it = opaStack.listIterator(opaStack.size());
        while (it.hasPrevious()) {
            Pair<Boolean, Integer> opa = it.previous();
            if (opa.getValue() != 4 && opa.getValue() != 5) {
                RPRStack.push(new Pair<>(true, cal(opa)));
            }
        }
        return RPRStack.peek().getValue();
    }

    public static void main(String[] args) {
        Cal_By_Reverse_Polish_Notation_1 solution = new Cal_By_Reverse_Polish_Notation_1();
        String[] tokens = {"3", "*", "(", "5", "+", "7", "/", "9", ")", "+", "10"};
        System.out.println("res" + solution.evalRPN(tokens));
    }
}

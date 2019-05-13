package com.leetcode;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author liubi
 * @date 2019-05-13 13:37
 * 输入一个表达式（合法），通过逆波兰表达式进行计算
 **/
public class Cal_By_Reverse_Polish_Notation {
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

    public int evalRPN(String[] tokens) {

        // 得到逆波兰表达式
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
                        RPRStack.push(top);
                    }
                }
                if (token.getValue() != 5) {
                    opaStack.push(token);
                }
            }
        }
        // 输出逆波兰表达式
        LinkedList<Integer> numStack = new LinkedList<>();
        ListIterator<Pair<Boolean,Integer>> iterator = RPRStack.listIterator(RPRStack.size());
        while (iterator.hasPrevious()){
            Pair<Boolean, Integer> token = iterator.previous();
            if (token.getKey()) {
                System.out.println(token.getValue());
            } else {
                switch (token.getValue()) {
                    case 0:
                        System.out.println("+");
                        break;
                    case 1:
                        System.out.println("-");
                        break;
                    case 2:
                        System.out.println("*");
                        break;
                    case 3:
                        System.out.println("/");
                        break;
                    case 4:
                        System.out.println("（");
                        break;
                    case 5:
                        System.out.println("（");
                        break;
                    default:
                        System.out.println("error");
                }
            }
        }
        // 根据逆波兰表达是计算结果 -----leetcode_150
        iterator = RPRStack.listIterator(RPRStack.size());
        while (iterator.hasPrevious()){
            Pair<Boolean, Integer> token = iterator.previous();
            if (token.getKey()) {
                numStack.push(token.getValue());
            } else {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                switch (token.getValue()) {
                    case 0:
                        numStack.push(num1 + num2);
                        break;
                    case 1:
                        numStack.push(num1 - num2);
                        break;
                    case 2:
                        numStack.push(num1 * num2);
                        break;
                    case 3:
                        numStack.push(num1 / num2);
                        break;
                    default:
                        System.out.println("error");
                }
            }
        }
        return numStack.peek();
    }

    public static void main(String[] args) {
        Cal_By_Reverse_Polish_Notation solution = new Cal_By_Reverse_Polish_Notation();
        String[] tokens = {"(", "(", "2", "+", "1", ")", "*", "3", ")"};
        System.out.println("res"+solution.evalRPN(tokens));
    }
}

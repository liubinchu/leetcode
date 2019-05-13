package com.leetcode;

import java.util.LinkedList;

/**
 * @author liubi
 * @date 2019-05-13 21:59
 **/
public class leetcode_227 {
    private LinkedList<Integer> stackOP = new LinkedList<>();
    private LinkedList<Integer> stackNum = new LinkedList<>();
    private int[][] op = new int[6][6];

    // +-*/() 的index为012345， op[2][3] 表示当前元素*（2）和栈顶元素/（3）的大小关系为< (-1)
    // (0表示相等 1 表示大于 -1小于 -2 非法)
    {
        op[0][0] = -1;
        op[0][1] = -1;
        op[0][2] = -1;
        op[0][3] = -1;
        op[0][4] = 1;
        op[0][5] = -2;
        op[1][0] = -1;
        op[1][1] = -1;
        op[1][2] = -1;
        op[1][3] = -1;
        op[1][4] = 1;
        op[1][5] = -2;
        op[2][0] = 1;
        op[2][1] = 1;
        op[2][2] = -1;
        op[2][3] = -1;
        op[2][4] = 1;
        op[2][5] = -2;
        op[3][0] = 1;
        op[3][1] = 1;
        op[3][2] = -1;
        op[3][3] = -1;
        op[3][4] = 1;
        op[3][5] = -2;
        op[4][0] = 1;
        op[4][1] = 1;
        op[4][2] = 1;
        op[4][3] = 1;
        op[4][4] = 1;
        op[4][5] = -2;
        op[5][0] = -1;
        op[5][1] = -1;
        op[5][2] = -1;
        op[5][3] = -1;
        op[5][4] = 0;
        op[5][5] = -2;
    }

    private int cal(LinkedList<Integer> stack, Integer op) {
        int num2 = stack.pop();
        int num1 = stack.pop();
        switch (op) {
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

    public int calculate(String s) {
        int numLast = 0;
        int OPcurr = 0;
        boolean lastOP = false;
        boolean currOP = false;
        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                numLast = numLast * 10 + c - '0';
                currOP = false;
                //stackNum.push(c-'0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                currOP = true;
                if (!lastOP) {
                    stackNum.push(numLast);
                    numLast = 0;
                }
                switch (c) {
                    case '+':
                        OPcurr = 0;
                        break;
                    case '-':
                        OPcurr = 1;
                        break;
                    case '*':
                        OPcurr = 2;
                        break;
                    case '/':
                        OPcurr = 3;
                        break;
                    default:
                        OPcurr = 6;
                }
                while (!stackOP.isEmpty() && op[OPcurr][stackOP.peek()] == -1) {
                    stackNum.push(cal(stackNum, stackOP.pop()));
                }
                while (!stackOP.isEmpty() && op[OPcurr][stackOP.peek()] == 0) {
                    stackOP.pop();
                }
                if (OPcurr != 5) {
                    stackOP.push(OPcurr);
                }
            }
            lastOP = currOP;
        }
        if (!currOP) {
            stackNum.push(numLast);
        }
        while (!stackOP.isEmpty()) {
            stackNum.push(cal(stackNum, stackOP.pollFirst()));
        }
        return stackNum.peek();
    }
    public static void main(String[] args) {
        leetcode_227 solution = new leetcode_227();
        System.out.println(solution.calculate("3+2*2"));
    }
}

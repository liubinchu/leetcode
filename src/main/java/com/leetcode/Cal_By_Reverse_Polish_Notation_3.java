package com.leetcode;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author liubi
 * @date 2019-05-14 15:08
 * version 3 : 加入合法性检查
 * 非法情况 存在一下几种
 * 1. 多一个数字 （等价于 少一个运算符）： RPRStack 栈的最后必须只有一个元素
 * 2. 少一个数子（等价于 多一个运算符）： 运算时，opaStack 不存在足够的数字
 * 3. 多一个运算符，少一个运算符
 * 4. 多一个左括号（少右括号）：当遍历完 中缀表达式后，括号应该全部匹配完成，运算符栈中不应存在左括号
 * 5. 多一个右括号（少左括号）：每当遇到一个右括号，都应匹配到一个左括号
 * */

public class Cal_By_Reverse_Polish_Notation_3 {
    private LinkedList<Pair<Boolean, Integer>> RPRStack = new LinkedList<>(); // 逆波兰表达式栈
    private LinkedList<Pair<Boolean, Integer>> opaStack = new LinkedList<>(); // 运算栈
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

    /**
     * @param token
     * @return Pair<true, Integer> if a number; Pair<false,Integer> if a operator +-* /() 的index为012345
     */
    private Pair<Boolean, Integer> parseToken(String token) {
        Pair<Boolean, Integer> res = null;
        if (token == null || token.length() == 0) {
            res = new Pair<>(false, 6);
        } else {
            char first = token.charAt(0);
            if (token.length() == 1 && first == '+') {
                res = new Pair<>(false, 0);
            } else if (token.length() == 1 && first == '-') {
                res = new Pair<>(false, 1);
            } else if (token.length() == 1 && first == '*') {
                res = new Pair<>(false, 2);
            } else if (token.length() == 1 && first == '/') {
                res = new Pair<>(false, 3);
            } else if (token.length() == 1 && first == '(') {
                res = new Pair<>(false, 4);
            } else if (token.length() == 1 && first == ')') {
                res = new Pair<>(false, 5);
            } else {
                try {
                    res = new Pair<>(true, Integer.parseInt(token));
                } catch (Exception e) {
                    res = new Pair<>(false, 6);
                }
            }
        }
        return res;
    }

    private boolean illegalOperator(String[] tokens, int currentIndex) throws Exception {
        if (currentIndex == 0 || currentIndex == tokens.length - 1) {
            return false;
        }
        Pair<Boolean, Integer> tokenBefore = parseToken(tokens[currentIndex - 1]);
        Pair<Boolean, Integer> tokenAfter = parseToken(tokens[currentIndex + 1]);
        if (!(tokenBefore.getKey() || (!tokenBefore.getKey() && tokenBefore.getValue().equals(5)))
                || !(tokenAfter.getKey() || (!tokenAfter.getKey() && tokenAfter.getValue().equals(4)))) {
            return false;
        }
        return true;
    }

    private int cal(Pair<Boolean, Integer> token) throws Exception {
        try {
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
                    throw new Exception("illegal expression: illegal operator when cal");
            }
        } catch (NoSuchElementException e) {
            throw new Exception("illegal expression: redundant operator or lack of operation number");
        }


    }

    public int evalRPN(String[] tokens) throws Exception {
        boolean isBracketsMatch = true;
        //for (String tokenString : tokens) {
        for (int i = 0; i < tokens.length; i++) {
            Pair<Boolean, Integer> token = parseToken(tokens[i]);
            if (token.getKey()) {
                // num
                RPRStack.push(token);
            } else {
                // operator
                if(token.getValue()<4&&token.getValue()>=0&&!illegalOperator(tokens,i)){
                    throw new Exception("illegal expression: cannot find number around operator (index:"+i+")" );
                }
                if (token.getValue().equals(5)) {
                    isBracketsMatch = false; // 出现右括号 需要匹配 左括号
                }
                while (!opaStack.isEmpty() && op[token.getValue()][opaStack.peek().getValue()] == -1) { // -2 illegal 没写
                    RPRStack.push(new Pair<>(true, cal(opaStack.pop()))); //在运算符进入逆波兰表达式时，计算结果
                }
                if (!opaStack.isEmpty() && op[token.getValue()][opaStack.peek().getValue()] == 0) { // -2 illegal 没写
                    isBracketsMatch = true;
                    opaStack.pop();
                }
                if (!isBracketsMatch) {
                    throw new Exception("illegal expression: \")\" can not match a \"(\"");
                }
                if (token.getValue() != 5) {
                    opaStack.push(token);
                }
            }
        }

        // 此时 中缀表达式 已经遍历完毕，所有"(" 应该已经匹配完毕，不在 运算符栈中出现
        ListIterator<Pair<Boolean, Integer>> it = opaStack.listIterator(opaStack.size());
        while (it.hasPrevious()) {
            Pair<Boolean, Integer> opa = it.previous();
            if (opa.getValue() == 4 || opa.getValue() == 5) {
                throw new Exception("illegal expression: \"(\" can be be matched");
            }
            RPRStack.push(new Pair<>(true, cal(opa)));
        }
        if (RPRStack.size() != 1) {
            throw new Exception("illegal expression: redundant number or lack of operator");
        }
        return RPRStack.peek().getValue();
    }

    public static void main(String[] args) throws Exception {
        Cal_By_Reverse_Polish_Notation_3 solution = new Cal_By_Reverse_Polish_Notation_3();
        String[] tokens = {"3", "*", "(","3", "+", "7", "/", "9", ")", "+", "10"};
        System.out.println("res:    " + solution.evalRPN(tokens));
    }
}

package com.leetcode;

/**
 * @author liubi
 * @date 2019-01-12 21:52
 **/
public class OfferSord12_64 {
    /** 算法解析：
     * 递归法 解题
     */
    char[] str = null;
    int cols = -1;
    int matrixSize = -1;

    private boolean isLegalPos(int pos) {
        if (pos >= 0 && pos < matrixSize) {
            return true;
        } else {
            return false;
        }
    }

    private boolean hasPathCore(int lastPosInMatrix, int posInStr, Character[] matrix) {
        if (posInStr >= this.str.length) {
            return true;
        } else {
            char current = this.str[posInStr];
            int[] posInMatrixs = new int[4];
            posInMatrixs[0] = lastPosInMatrix + 1;
            posInMatrixs[1] = lastPosInMatrix - 1;
            posInMatrixs[2] = lastPosInMatrix + this.cols;
            posInMatrixs[3] = lastPosInMatrix - this.cols;
            for (int posInMatrix : posInMatrixs) {
                if (isLegalPos(posInMatrix) && matrix[posInMatrix] != null && matrix[posInMatrix].equals(this.str[posInStr])) {
                    Character[] matrixCopy = matrix.clone();
                    matrixCopy[posInMatrix] = null;
                    if (hasPathCore(posInMatrix, posInStr+1, matrixCopy)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.str = str;
        this.cols = cols;
        this.matrixSize = rows * cols;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0]) {
                Character[] matrixCopy = new Character[matrix.length];
                int index = 0;
                for (char c : matrix) {
                    matrixCopy[index++] = c;
                }
                matrixCopy[i] = null;
                if (hasPathCore(i, 1, matrixCopy)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OfferSord12_64 solution = new OfferSord12_64();
        char[] matrix = "abcesfcsadee".toCharArray();
        char[] str = "abcb".toCharArray();
        System.out.println(solution.hasPath(matrix, 3, 4, str));
    }
}

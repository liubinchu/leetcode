package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-18 19:36
 **/
public class OfferSord51_34 {
    public int InversePairsOld(int [] array) {
        int counter = 0;
        if(array.length == 0|| array.length == 1) {
            counter = 0;
        }
        else {
            for(int i = array.length-2;i>=0;i--){
                int currentNum = array[i];
                for(int j=i+1;j<array.length;j++){
                    if(array[j] < currentNum){
                        array[j-1] = array[j];
                        array[j] = currentNum;
                        counter++;
                    }
                }
            }
        }
        System.out.println(counter);
        return  counter;
    }
    public  int InversePairs(int[] data) {
        if (data == null || data.length < 1) {
            throw new IllegalArgumentException("Array arg should contain at least a value");
        }

        int[] copy = new int[data.length];
        System.arraycopy(data, 0, copy, 0, data.length);

        return inversePairsCore(data, copy, 0, data.length - 1);
    }

    private static int inversePairsCore(int[] data, int[] copy, int start, int end) {

        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        // 前半段的最后一个数字的下标
        int i = start + length;
        // 后半段最后一个数字的下标
        int j = end;
        // 开始拷贝的位置
        int indexCopy = end;
        // 逆序数
        int count = 0;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy] = data[i];
                indexCopy--;
                i--;
                count += j - (start + length); // 对应的逆序数
            } else {
                copy[indexCopy] = data[j];
                indexCopy--;
                j--;
            }
        }

        for (; i >= start;) {
            copy[indexCopy] = data[i];
            indexCopy--;
            i--;
        }

        for (; j >= start + length + 1;) {
            copy[indexCopy] = data[j];
            indexCopy--;
            j--;
        }
        return count + left + right;
    }

    public static void main(String[] args) {
        OfferSord51_34 solution = new OfferSord51_34();
        int[] test = {1,2,3,4,5,6,7,0};
        System.out.println(solution.InversePairs(test));
    }
}

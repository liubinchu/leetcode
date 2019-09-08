package com.leetcode.Search;

/**
 * @author liubi
 * @date 2018-11-21 18:31
 **/
public class OfferSord11_06 {
    private void reverseArray(int[] array, int startIndex, int length) {
        int counter = length / 2;
        while (counter-- > 0) {
            int temp = array[startIndex + counter - 1];
            array[startIndex + counter - 1] = array[startIndex + length - counter];
            array[startIndex + length - counter] = temp;
        }
    }

    private int[] getOriginArray(int[] array) {
        if (array.length == 0) {
            return array;
        } else {
            int changeIndex = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    changeIndex = i;
                    break;
                }
            }
            reverseArray(array, 0, changeIndex + 1);
            reverseArray(array, changeIndex, array.length - changeIndex - 1);
            reverseArray(array, 0, array.length);
            // 至此得到旋转前的数组
            return array;
        }
    }

    public int minNumberInRotateArray_1(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            int resultIndex = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    resultIndex = i + 1;
                    break;
                }
            }
            return array[resultIndex];
        }
    }

    /**
     * 改进算法， 利用了二分查找的思想。 前后两个子数组都是有序数组 O（logn）
     * 二分思想： 只要前后两个索引变化范围内是有序 那么 就可以使用二分
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = (index1 + index2) / 2;
        if (array.length == 0) {
            return 0;
        } else if (array[index1] == array[index2] && array[index1] == array[mid]) {
            // 元素全等 或者 大多数元素相等的情况
            int resultIndex = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    resultIndex = i + 1;
                    break;
                }
            }
            return array[resultIndex];
        } else if (array[index1] < array[index2]) {
            // 旋转数组为有序数组 也即 旋转元素个数为0
            return array[index1];
        } else {
            // 通常情况
            while (index1 + 1 < index2) {
                if (array[mid] >= array[index1]) {
                    index1 = mid;
                } else if (array[mid] <= array[index2]) {
                    index2 = mid;
                } else {
                    System.out.println("wrong index1 and index2");
                    // index1 <= index2 永远成立 上述两种条件永远成立
                }
                mid = (index1 + index2) / 2;
            }
            return array[index1 + 1];
        }
    }



    public static void main(String[] args) {
        OfferSord11_06 solution = new OfferSord11_06();
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(solution.minNumberInRotateArray(array));
    }
}

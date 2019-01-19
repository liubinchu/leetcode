package com.leetcode;

// 解题报告：1.java中分为基本类型变量和引用类型变量 基本类型变量对应内存中的值 引用类型变量存储的只是对象的地址
// 2. 引用类型变量 a = b 只是引用及地址的赋值 若要重新生成新的对象 调用 clone()
// 3. 这道题本身第一个想法是 自己写一个伪随机数生成器 通过线性同余法 进行操作 因为记得 线性同余能取得一定范围内的所有数字 并且符合均匀分布 但是通过查阅 密码学这本书 发现 只能在某一些情况下取得一定范围内的所有值 因此不可行
// 4， 第二个想法： 两个容器 从第一个容器中 随机的取出(不放回)一个元素， 放入另一个容器中 空间复杂度为O（n）时间复杂度： 从第一个容器中随机取数不放回 设计到删除操作 如果用链表 O(n) 如果用数组O(n2)
// 5. 看了答案之后 有一个更简单的方法： 上述方法中 将第一个容器中的元素 删除 添加到第二个容器中的操作 可以在同一个容器中进行 避免删除带来的额外操作 也 减少空间使用

import java.util.Random;

public class leetcode_384 {
    class Solution {
        private int[] array;
        private int[] original;
        private Random rand = new Random();

        public Solution(int[] nums) {
            array = nums;
            original = nums.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = original.clone();
            return array;
        }

        public void swapAt(int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        public int[] shuffle() {
            for (int i = 0; i < array.length; i++) {
                int j = rand.nextInt(array.length - i) + i;
                swapAt(i, j);
            }
            return array;
        }
    }
}

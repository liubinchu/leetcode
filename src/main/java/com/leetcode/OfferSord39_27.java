package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-10 19:19
 **/
public class OfferSord39_27 {
    /**
     * 辅助函数 : 判断给定的数字 是否满足条件： 出现次数大于数组长度的一半
     * @param num
     * @param array
     * @return
     */
    private boolean checkMoreThanHalf(int num, int[] array){
        int count = 0;
        for(int element: array){
            if(num == element){
                count++;
            }
        }
        return count>array.length/2;
    }

    /**
     * 算法分析：思路一： 利用map 记录每个元素出现的次数 时间空间复杂度 都是O（n） （但是需要检查是否满足 条件1）
     * 思路二： 先排序, 因为要求元素的个数大于数组元素总个数的一半（条件1） 因此排好序的数组中 中间元素 就是要求元素（但是需要检查是否满足 条件1）
     * 思路三： 因为满足条件1  要求元素的个数大于数组元素总个数的一半， 因此 要求元素个数-其余所有元素个数相加 仍大于0 因此 可以实现如下算法：（但是需要检查是否满足 条件1）
     * 思路四： 利用快排 partition的思想， 待实现
     * @param array
     * @return
     * @throws Exception
     */
    public int MoreThanHalfNum_Solution(int [] array) throws Exception{
        if(array.length==0) {
            return -1;
        }
        else{
            int result = array[0];
            int count = 1;
            for(int i=1;i<array.length;i++){
                if(count==0){
                    result = array[i];
                    count++;
                }
                else if(count<0){
                    throw new Exception("compute error");
                }
                else if(array[i] == result){
                    count++;
                }
                else if(array[i]!= result){
                    count--;
                }
            }
            if(checkMoreThanHalf(result,array)){
                return result;
            }
            else{
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        OfferSord39_27 solution = new OfferSord39_27();
    }
}

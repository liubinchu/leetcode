package com.leetcode;

/**
 * @author liubi
 * @date 2018-12-03 10:30
 **/
public class OfferSord33_22 {
    /**
     * 算法思想：序列的最后一个数 一定是根节点
     * 因为是二叉排序树 序列的前半部分 一定都小于 该数
     * 序列的后半部分 一定都大于该数
     * 那么先寻找 划分点 假设划分点前的数为前半部分
     * 如果 后半部分中出现小于最后一个数的数字 那么 return false
     * 再递归检查其他部分
     * @param sequence
     * @param startIndex
     * @param endIndex
     * @return
     */
    public boolean checkFun(int [] sequence, int startIndex, int endIndex){
        if(startIndex == endIndex || startIndex+1 == endIndex){
            return true;
        }
        else{
            int last = sequence[endIndex];
            int i = startIndex;
            while(i<endIndex){
                if(sequence[i++]>last){
                    break;
                }
            }
            int mid = i-1;
            while(i<endIndex){
                if(sequence[i++]<last){
                    return false;
                }
            }
            return checkFun(sequence,startIndex,mid) && checkFun(sequence,mid+1,endIndex);
        }
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) {
            return false;
        }
        else{
            return checkFun(sequence,0,sequence.length-1);
        }
    }
    public static void main(String[] args) {
        OfferSord33_22 solution = new OfferSord33_22();
    }
}

package com.liubinchu;

public class leetcode_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1= m-1;
        int index2= n-1;
        for(int index = m+n-1 ; index>=0; index--){
            //注意判断边界影响
            if(index1<0){
                nums1[index] = nums2[index2];
                index2--;
            }
            else if(index2<0){
                nums1[index] = nums1[index1];
                index1--;
            }
            else if(nums1[index1]>nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            }
            else {
                nums1[index] = nums2[index2];
                index2--;
            }
        }
    }
}

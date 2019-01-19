package com.leetcode;

public class leetcode_278 {
    // The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version){return true;}
    // !!!!!!!!!!!!!!!!!!!!!!!!!! 上述函数由oj系统自定义
    // 用递归做 stackOverFlow
    public int BinarySearch(int i,int j){
        int mid = (i+j)/2;
        boolean midCheck = isBadVersion(mid);
        if(mid+1<=j) {
            boolean mid_1Check = isBadVersion(mid+1);
            if(midCheck == false && mid_1Check == false) return BinarySearch(mid+1,j); //向后找
            if(midCheck == true && mid_1Check == true) return BinarySearch(i,mid-1);  //向前找
            if(midCheck == false && mid_1Check == true) return mid+1;
            if(midCheck == true && mid_1Check == false) return mid;
        }
        // i ==j
        else if(midCheck == false ) return -1;// 不存在错误版本
        else if(midCheck == true) return mid; //finded
        return -2; //其他错误情况
    }
    public int firstBadVersion(int n) {
        //return BinarySearch(1,n);
        int low = 1;
        int high = n;
        while(low <= high){
            int mid= low+(high - low)/2;  // 数据量很大时 high+low 会溢出 因此不用
            boolean midCheck = isBadVersion(mid);
            if(low == high && midCheck == true) return low;
            else if(low == high && midCheck == false) return -1; // not exist
            else if(low != high) {
                boolean mid_1Check = isBadVersion(mid+1);
                if(midCheck == false && mid_1Check == false) low = mid;
                if(midCheck == true && mid_1Check == true) {
                    if(mid==1) return 1;
                    else high = mid;
                }
                if(midCheck == false && mid_1Check == true) return mid+1; //找到
            }
        }
        return -2;
    }
}

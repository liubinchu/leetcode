package com.leetcode;
import java.util.Arrays;


/**
 * @author liubi
 * @date 2019-03-14 19:54
 **/
public class CloneExample implements Cloneable{
    private int[] arr;
    public CloneExample() {
        arr = new int[1];
    }
    public void set(int index, int value) {
        arr[index] = value;
    }
    public int get(int index) {
        return arr[index];
    }

    // 深拷贝
    @Override
    public CloneExample clone() throws CloneNotSupportedException {
        CloneExample result = (CloneExample) super.clone();
        result.arr = Arrays.copyOf(this.arr,this.arr.length);
        return result;
    }
    // 复制构造函数
    public CloneExample (CloneExample cloneExample){
        this.arr = Arrays.copyOf(cloneExample.arr,cloneExample.arr.length);
    }
    // 拷贝工厂
    public static CloneExample deepCopyFactory(CloneExample cloneExample){
        CloneExample deepCopy = new CloneExample();
        deepCopy.arr = Arrays.copyOf(cloneExample.arr,cloneExample.arr.length);
        return deepCopy;
    }
    public static  void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException {
        Class.forName("notExist");
        CloneExample object1 = new CloneExample();
        object1.set(0,1);
        CloneExample deepCopy = object1.clone();
        CloneExample cloneConstructor = new CloneExample(object1);
        CloneExample deepCopyFactory = CloneExample.deepCopyFactory(object1);
        System.out.println("before change object1");
        for(int data :deepCopy.arr){
            System.out.print(data + " ");
        }
        object1.arr[0] = 10;
        System.out.println("\n after change object1 & deepCopy");
        for(int data :deepCopy.arr){
            System.out.print(data + " ");
        }
        System.out.println("\n after change object1 & cloneConstructor");
        for(int data :cloneConstructor.arr){
            System.out.print(data + " ");
        }
        System.out.println("\n after change object1 & deepCopyFactory");
        for(int data :deepCopyFactory.arr){
            System.out.print(data + " ");
        }
    }
}
/*
before change object1
1
 after change object1 & deepCopy
1
 after change object1 & cloneConstructor
1
 after change object1 & deepCopyFactory
1 */

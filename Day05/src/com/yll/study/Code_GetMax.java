package com.yll.study;

/**
 * 通过递归找到最大值
 */
public class Code_GetMax {
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    private static int process(int[] arr, int L, int R) {
        System.out.println("L = " + L+" R = "+R);
        if (L==R){
            return arr[L];
        }
        int mid = L+((R-L)>>1);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,8};
        System.out.println(process(arr, 0, arr.length - 1));
    }
}

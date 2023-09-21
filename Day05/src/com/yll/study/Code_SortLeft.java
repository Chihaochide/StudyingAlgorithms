package com.yll.study;

import java.util.Arrays;

public class Code_SortLeft {
    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "bb";
        int i1 = 1;
        int i2 = 2;
        int flag = 0;
        System.out.println(i1 ^ i2);
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            flag ^= s1.charAt(i)^s2.charAt(i);
        }
        System.out.println("flag = " + flag);
    }

    private static int process(int[] arr, int L, int R) {
        if (L==R) return arr[L];
        int mid = L+((R-L)>>1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }

    private static void merge(int[] arr, int l, int mid) {
        if (arr[l]>arr[mid]){
            int t = arr[l];
            arr[l] = mid;
            arr[mid] = t;
        }
    }


}

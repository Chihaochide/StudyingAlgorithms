package com.yll.study;

import java.util.Arrays;

public class InsertSort {
    public static void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

    }
    public static void insertSort(int[] arr){
        if (arr==null||arr.length==0) System.exit(1);
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0;j<i;j--){
                if (arr[i]<arr[j]){
                    swap(arr,i,j);
                }
            }
        }
    }

    public static void insertSort2(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1;j>=0 && arr[j]>arr[j+1];j--){
                swap(arr,j,j+1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,7,3,5,8,13,12,19,20,2};
        insertSort2(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}

package com.yll.study;

import java.util.Arrays;
import java.util.Collections;

public class SelectionSort {
    public static void swap(int[] arr,int a,int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

    }
    public static void selectSort(int[] arr){
        if (arr==null||arr.length==0) System.exit(1);
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i+1;j<length;j++){
                if (arr[min]>arr[j]){
                    min = j;
                }
            }
            swap(arr,i,min);

        }


    }
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,3,4,8,1,1,3,2,123,4,3,4,5,6,7,4,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

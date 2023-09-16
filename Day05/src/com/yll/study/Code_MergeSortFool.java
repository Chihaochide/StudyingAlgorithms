package com.yll.study;

import java.util.Arrays;

/**
 * 归并排序，呆瓜算法
 */
public class Code_MergeSortFool {

    public static void process(int[] arr,int L,int R){
//        System.out.println(" L = "+L);
//        System.out.println(" R = "+R);
        if (L==R) {
//            System.out.println("================");
            return;
        }

        int mid = L+((R-L)>>1);

        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {

        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while (p1 <= mid && p2<=R){
            help[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }

        while (p1<=mid){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        for (i =0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,8,5,9};
        process(arr,0, arr.length-1);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}

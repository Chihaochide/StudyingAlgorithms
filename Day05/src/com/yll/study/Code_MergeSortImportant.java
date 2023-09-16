package com.yll.study;

import java.util.Arrays;

/**
 * 归并排序：用迭代
 */
public class Code_MergeSortImportant {

    public static void merge(int[] arr,int L,int mid,int R){
        int[] helpArr = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        while (p1<=mid && p2<=R){
            helpArr[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }

        while (p1<=mid){
            helpArr[i++] = arr[p1++];
        }
        while (p2<=R){
            helpArr[i++] = arr[p2++];
        }
        for (i = 0;i<helpArr.length;i++){
            arr[L+i] = helpArr[i];
        }


    }


    // 这个是用递归的方法实现的归并排序
    public static void process(int[] arr,int L,int R){
        if (L==R) return;;
        int mid = L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    // 使用迭代的形式进行归并排序
    public static void process2(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        int N = arr.length; // 数组的长度
        int mergerSize = 1; // 步长
        while (mergerSize<N){
            int L = 0; // 左下标的初始位置
            while (L<N){
                int M = L+mergerSize-1; // 左组最后的位置
                if (M>=N) break;
                int R = Math.min(M+mergerSize,N-1); // 右组最后的位置
                System.out.format("L = %d M = %d R = %d\n",L,M,R);
                merge(arr,L,M,R);
                System.out.println(Arrays.toString(arr)+"\n");
                L = R+1;
            }
            if (mergerSize>N/2) break;
            mergerSize = mergerSize<<1;
        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
//        process(arr,0,arr.length-1);
        process2(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}

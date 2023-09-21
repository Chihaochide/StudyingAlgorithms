package com.yll.study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

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
                merge(arr,L,M,R);
                L = R+1;
            }
            if (mergerSize>N/2) break;
            mergerSize = mergerSize<<1;
        }
    }


    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    public static int[] getArray(int maxLength,int maxNum){
        int length = (int)(Math.random()*(maxLength+1));
        int[] arr = new int[length];
        System.out.println("length = " + length);
        for (int i = 0; i < length; i++) {
            arr[i] = getRandom(maxNum);
        }
        return arr;
    }
    public static int getRandom(int MaxNum){
        return (int)((MaxNum+1)*Math.random())-(int) (MaxNum*Math.random());
    }
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        int[] arr2 = getArray(150000,30000);
        long startTime = System.currentTimeMillis();
//        process(arr2,0,arr2.length-1);
        process2(arr2);
        long endTime = System.currentTimeMillis();
        System.out.println("process2 执行时间："+(endTime-startTime)/1000.0+"s");

        startTime = System.currentTimeMillis();
        process(arr2,0,arr2.length-1);
        endTime = System.currentTimeMillis();
        System.out.println("process 执行时间："+(endTime-startTime)/1000.0+"s");

        startTime = System.currentTimeMillis();
        bubbleSort(arr2);
        endTime = System.currentTimeMillis();
        System.out.println("process 执行时间："+(endTime-startTime)/1000.0+"s");

    }
}

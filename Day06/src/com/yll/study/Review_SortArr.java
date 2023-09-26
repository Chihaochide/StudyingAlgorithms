package com.yll.study;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 用迭代的形式对数组进行归并排序
 * 时间复杂度：O(N*logN)
 */
public class Review_SortArr {


    /**
     * 生成一个随机数组
     */
    public static int[] getArr(int MaxNum,int MaxLength){
        int[] arr = new int[(int)(Math.random()*MaxLength)+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandom(MaxNum);
        }
        return arr;

    }

    /**
     * 生成随机数
     */
    private static int getRandom(int seed){
        return (int)(Math.random()*seed+1)-(int)(Math.random()*seed);
    }

    /**
     * 迭代的归并排序入口
     */
    public static void process(int[] arr){

        int N = arr.length; // 数组的长度
        int mergeSize = 1; // 步长
        while (mergeSize<N){
            int L = 0; // 左组下标的初始位置
            while (L<N){ // 左组下标初始位置小于 数组长度的时候
                int M = L+mergeSize-1; // 左组下标的最后位置
                if (M>=N) break; // 越界啦
                int R = Math.min(M+mergeSize,N-1); // 右组下标的最后位置
                merge(arr,L,M,R);
                L = R+1; // 左组往后挪
            }
            if (mergeSize>N/2) break;
            mergeSize <<=1; // mergeSize*2
        }


    }

    /**
     * 排序算法
     */

    public static void merge(int[] arr,int L,int mid,int R){
        int[] helpArr = new int[R-L+1];
        int p1 = L,i=0;
        int p2 = mid+1;

        while (p1<=mid&&p2<=R){
            helpArr[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=mid){
            helpArr[i++] = arr[p1++];
        }
        while (p2<=R){
            helpArr[i++] = arr[p2++];
        }
        for (i = 0;i< helpArr.length;i++){
            arr[L+i] = helpArr[i];
        }

    }


    public static void main(String[] args) {

        int[] arr = getArr(300,5);
        int[] arr1 = new int[]{5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        process(arr);
        System.out.println(Arrays.toString(arr));

    }

}

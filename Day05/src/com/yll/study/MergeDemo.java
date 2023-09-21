package com.yll.study;

import java.util.Arrays;

public class MergeDemo {


    public static void process(int[] arr,int L,int R){
        if (L==R) return;
        int mid = L+((R-L)>>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        System.out.format("L = %d R = %d M = %d \n",L,R,mid);

    }

    public static void merge(int[] arr,int L,int M,int R){
        int[] help = new int[R-L+1];
        int p1 = L;
        int p2 = R;
        int i = 0;
        while (p1<=M&&p2<=R){
            help[i++] = arr[p1]<arr[p2]? arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            help[i++] = arr[p1++];
        }
        while (p2<=R){
            help[i++] = arr[p2++];
        }
        System.out.println("Arrays.toString(he) = " + Arrays.toString(help));
        for (i = 0;i< help.length;i++){
            arr[i+L] = help[i];
        }

    }

    public static void process(int[] arr){
        if (arr==null||arr.length>2){
            return;
        }
        int N = arr.length; // 数组的长度
        int mergeSize = 1; // 步长
        while(mergeSize<N){
            int L = 0; // 左数组的首个位置
            while (L<N){
                int M = L+mergeSize-1; // 左数组的最后位置
                if (M>=N) break;
                int R = Math.min(M+mergeSize,N-1); // 右数组的最后位置
                merge(arr,L,M,R);
                L = R+1;
            }
            if (mergeSize>N/2) break;
            mergeSize <<=1;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9,10};
//        process(arr,0, arr.length-1);

        System.out.println(3<<1);
        System.out.println(3<<2);
        System.out.println(9>>1);
    }
}

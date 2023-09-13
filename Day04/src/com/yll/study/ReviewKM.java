package com.yll.study;


import java.util.Arrays;

public class ReviewKM {
    public static void main(String[] args) {
        System.out.println(GetK(new int[]{6, 6, 6, 2, 2, 2, 2, 1, 1, 1, 1}, 3, 4));
    }
    public static int GetK(int[] arr,int k,int m){
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                t[i] += num>>i&1;
            }
        }

        int flag = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i]%m != 0){
                flag = flag|1<<i;
            }
        }
        System.out.println(Arrays.toString(t));
        return flag;
    }
}

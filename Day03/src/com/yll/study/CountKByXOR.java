package com.yll.study;

import java.util.Arrays;

/**
 * 一个数组中有一种数出现了K次，其它数出现了M次
 * M>1，k<M
 * 找到出现了K次的数
 * 要求：额外空间复杂度O(1)
 */
public class CountKByXOR {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,3,3,3,4,5,5,5};
        System.out.println(KM(arr, 1, 3));
        int[] key = {6,6,3,3,3};
        System.out.println(SearchKm(key, 2, 3));
        System.out.println(1|1<<3);
//        1<<3：1符号左移3位
//        1<<3 --> 1000
//        1-->0001
//        1000|0001 = 1001 -->9
    }

    // 保证arr中，只有一种数出现了K次，其余数都出现了M次
    public static int KM(int[] arr,int k,int m){
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0;i<=31;i++){

//                if (((num>>i)&1)!=0){
//                    t[i]++;
//                }
                // 优化版
                t[i] += (num>>i)&1;
            }
        }
        int ans = 0;
        for (int i=0;i<32;i++){
            if (t[i]%m !=0){ // 在第i位置上有1
                ans |=(1<<i);
            }
        }
        return ans;
    }

    public static int SearchKm(int[] arr,int k,int m){
        int[] t = new int[32];
        for (int num : arr) {
            for (int i = 0;i<32;i++){
                t[i] += (num>>i)&1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i]%m !=0){
                ans |=(1<<i);
            }
        }
        System.out.println(Arrays.toString(t));

        return ans;
    }
}

package com.yll.study;


import java.util.Arrays;

public class Code_SimpleSum {

    public static int process(int[] arr,int l,int r){

        if (l == r){
            return 0;
        }
        int mid = l+((r-l)>>1);
        return process(arr,l,mid)+
                process(arr,mid+1,r)+
                merge(arr,l,mid,r);

    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r-l+1];
        int p1 = l,i=0,p2 = m+1;
        int res = 0;
        while (p1<=m && p2<=r){
            res += arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0;
            help[i++] = arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=m){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for (i = 0;i<help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(process(arr, 0, 4));
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}

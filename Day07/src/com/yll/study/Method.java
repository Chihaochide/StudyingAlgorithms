package com.yll.study;

import java.util.Arrays;

public class Method {
    public static int[] insert(int i){
        int[] arr = new int[6];
        int flag = (int)(Math.random()*6);
        do {
            arr[flag] = 1;

            flag = (int)(Math.random()*6);
        }while (i>0);
        return arr;
    }
    public static void main(String[] args) {
        int[] insert = insert(3);
        System.out.println("Arrays.toString(in) = " + Arrays.toString(insert));
    }
}

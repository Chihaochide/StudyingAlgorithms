package com.yll.study;

import java.util.Arrays;

public class Code_MyHeap {
    public static void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2; 
        }
    }

    public static void heapIfy(int[] arr,int index,int heapSize){
        int left = index*2+1;
        while (left<heapSize){
            int largest = left+1<heapSize&&arr[left+1]>arr[left]? left+1:left;
            largest = arr[largest]>arr[index]? largest:index;
            if (largest==index) break;
            swap(arr,index,largest);
            index = largest;
            left = index*2+1;

        }
    }

    public static void headSort(int[] arr){
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heapIfy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;
    }

    public static int[] getArr(int MaxNum,int MaxLength){
//        int[] arr = new int[(int)(Math.random()*MaxLength)+1];
        int[] arr = new int[MaxLength];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandom(MaxNum);
        }
        return arr;
    }

    private static int getRandom(int maxNum) {
        return (int)(Math.random()*maxNum+1)-(int)(Math.random()*maxNum);
    }

    public static void main(String[] args) {
        int[] arr = getArr(30000,150000);
        long startTime = System.currentTimeMillis();
        headSort(arr);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime = " + (endTime-startTime)/1000.0+"s");
    }
}

package com.yll.study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code_HeapInsert {

    public static void heapInsert(int[] arr,int index){
        while (arr[index]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public static void heapIfy(int[] arr,int index,int heapSize){
        int left = index*2+1;
        while (left<heapSize){
            int largest = left+1<heapSize && arr[left+1]>arr[left]?left+1:left;
            if (largest==index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index+2+1;
        }
    }

    private static void swap(int[] arr, int index, int i) {
        int t = arr[index];
        arr[index] = arr[i];
        arr[i] = t;
    }

    public static class MyCompare implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }


    // 堆排序
    public static void heapSort(int[] arr){
        if (arr==null || arr.length<2){
            return;
        }
        for (int i =0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heapIfy(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void main(String[] args) {

/*        PriorityQueue<Integer> heap = new PriorityQueue<>(new MyCompare());
        heap.add(5);
        heap.add(3);
        System.out.println("head.peek() = " + heap.peek());
        heap.add(7);
        heap.add(0);
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }*/
        int[] arr = new int[]{7,5,2,1,3,8};
        heapSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}

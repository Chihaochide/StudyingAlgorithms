package com.yll.study;

/**
 * 利用二分查找法查找一个数在数组中的最左位置
 */
public class BinarySearchNumLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,4,5,5,5,6,7};
        System.out.println(SearchLeft(arr, 5));
    }

    public static int SearchLeft(int[] arr,int num){
        int left = 0;
        int right = arr.length;
        while (left<right){
            int mid = (left+right)/2;
            if (arr[mid]>=num){
                right = mid;

            }else if (arr[mid]<num){
                left = mid+1;
            }

        }
        return right;

    }
}

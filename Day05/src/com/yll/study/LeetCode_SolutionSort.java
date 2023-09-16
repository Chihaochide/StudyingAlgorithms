package com.yll.study;

import java.util.Arrays;

/**
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 */
public class LeetCode_SolutionSort {
    
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int[] help = new int[m+n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1<m&&p2<=n){
            help[i++] = nums1[p1]<=nums2[p2]? nums1[p1++]:nums2[p2++];
        }
        while (p1<m){
            help[i++] = nums1[p1++];
        }
        while (p2<n){
            help[i++] = nums2[p2++];
        }
        System.out.println("Arrays.toString(help) = " + Arrays.toString(help));
    }
    public static void main(String[] args) {
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        merge(num1,3,num2,3);
    }
}

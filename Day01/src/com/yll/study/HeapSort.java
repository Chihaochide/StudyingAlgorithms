package com.yll.study;

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 构建最大堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 逐个提取最大元素并调整堆
        for (int i = n - 1; i > 0; i--) {
            // 将当前最大元素（堆顶）与数组末尾元素交换
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 调整堆，将剩余的元素继续排序
            heapify(arr, i, 0);
        }
    }

    // 调整堆，使其满足最大堆的性质
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 初始化最大元素的位置
        int leftChild = 2 * i + 1; // 左子节点的位置
        int rightChild = 2 * i + 2; // 右子节点的位置

        // 如果左子节点存在并且大于最大元素，则更新最大元素位置
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // 如果右子节点存在并且大于最大元素，则更新最大元素位置
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // 如果最大元素位置不是当前节点位置，则交换它们，并递归调整堆
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 递归调整子树
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.println("原始数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        heapSort(arr);

        System.out.println("\n排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

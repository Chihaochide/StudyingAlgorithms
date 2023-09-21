package com.yll.study;

import java.util.Arrays;
import java.util.List;

class Solution {
    public static class MyNode{
        public MyNode next;
        public int value;
        public MyNode(int value){
            this.value = value;
        }
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    public static int missingNumber(int[] nums) {
        if(nums ==null) return -1;
        int length = nums.length;
        int L = 0;
        int R = length-1;
        int mid = 0;
        while(L<=R){
            mid = L+((R-L)>>1);
            if(nums[mid]<=mid){
                L = mid+1;
            }else if(nums[mid]>mid){
                R = mid-1;
            }
        }
        return L;

    }

    public static void reverse(MyNode head){
        MyNode pre = null;
        MyNode next = null;
        while (head!=null){
           next = head.next;
           head.next = pre;
           pre = head;
           head = next;
        }
    }

    public static MyNode getKthFromEnd(MyNode head, int k) {
        MyNode frontNode = head,behidNode = head;
        while(frontNode!=null && k>0){
            frontNode = frontNode.next;
            k--;
        }
        while(frontNode!=null){
            frontNode = frontNode.next;
            behidNode = behidNode.next;
        }
        return behidNode;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        int sum  = getLength(l1,l2);
        int[] arr = new int[sum];
        int i = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                arr[i++] = p1.val;
                p1 = p1.next;
            }else{
                arr[i++] = p2.val;
                p2 = p2.next;
            }

        }
        while(p1!=null){
            arr[i++] = p1.val;
            p1 = p1.next;
        }
        while(p2!=null){
            arr[i++] = p2.val;
            p2 = p2.next;
        }
        System.out.println(Arrays.toString(arr));
        ListNode help = new ListNode(0);
        ListNode head = help;
        for (int i1 = 0; i1 < sum; i1++) {
            help = new ListNode(arr[i]);
            help = help.next;
        }
        return null;
    }

    private static int getLength(ListNode l1, ListNode l2) {
        if (l1==null && l2 ==null) return 0;
        int lengthL1 = (l1 != null) ? 1 + getLength(l1.next, null) : 0;
        int lengthL2 = (l2 != null) ? 1 + getLength(null, l2.next) : 0;

        return lengthL1+lengthL2;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        if (l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }



    public static void main(String[] args) {
/*
        MyNode node = new MyNode(1);
        node.next = new MyNode(2);
        node.next.next = new MyNode(3);
        node.next.next.next = new MyNode(4);
        node.next.next.next.next = new MyNode(5);

        MyNode kthFromEnd = getKthFromEnd(node, 1);
        while (kthFromEnd!=null){
            System.out.println(kthFromEnd.value);
            kthFromEnd = kthFromEnd.next;
        }
*/


        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(7);



        ListNode l3 = mergeTwoLists(l1,l2);
        System.out.println(l3.toString());
    }
}
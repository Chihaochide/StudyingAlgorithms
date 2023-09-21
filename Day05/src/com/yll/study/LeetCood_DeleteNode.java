package com.yll.study;

public class LeetCood_DeleteNode {
    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


    public static ListNode deleteNode(ListNode head,int val){
        while (head!=null){
            if (head.val!=val){
                break;
            }
            head = head.next;
        }
        ListNode cur = head;
        ListNode pre = head;
        while (cur!=null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        System.out.println(head);
        ListNode lastNode = deleteNode(head, 2);
        System.out.println("lastNode = " + lastNode);
    }
}

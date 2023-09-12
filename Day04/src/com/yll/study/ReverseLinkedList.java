package com.yll.study;

/**
 * 反转单链表
 */
public class ReverseLinkedList {
    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }

    public static Node reverseLinked(Node head){
        Node pre = null;
        Node next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        Node pre = reverseLinked(node);
        System.out.println(pre.value+" "+pre.next.value+" "+pre.next.next.value);
    }


}

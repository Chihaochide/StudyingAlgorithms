package com.yll.study;

public class RemoveLinkedListValue {
    public static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static Node removeValue(Node head,int num){
        // 找到第一个不需要被删除的节点
        while (head!=null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null){
            if (cur.value == num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }


    public static Node removeNum(Node head,int num){
        while (head!=null){
            if (head.value!=num){
                break;
            }
            head = head.next;
        }

        Node cur = head;
        Node pre = head;
        while (cur!=null){
            if (cur.value ==num){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(7);

        Node node2 = removeValue(node, 2);

        while (node2!=null){
            System.out.println(node2.value);
            node2 = node2.next;
        }
    }
}

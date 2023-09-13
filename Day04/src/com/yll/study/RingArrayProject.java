package com.yll.study;

import java.util.Arrays;

public class RingArrayProject {
    public static class MyQueue{
        public int[] arr;
        public int[] arrMin;
        public int pollI;
        public int pushI;
        public int size;
        public final int limit;
        public int minFlag;

        public MyQueue(int limit){
            arr = new int[limit];
            arrMin = new int[limit];
            pollI = 0;
            pushI = 0;
            size = 0;
            minFlag = -1;
            this.limit = limit;

        }

        public void push(int value){
            if (size==limit){
                throw new RuntimeException("满了！别加了!");
            }

            arr[pushI] = value;
            if (size == 0){
                arrMin[pushI] = value;
            }else {
                if (arrMin[pushI-1]<value){
                    arrMin[pushI] = arrMin[pushI-1];
                }else {
                    arrMin[pushI] = value;
                }
            }

            pushI = nextIndex(pushI);
            size++;
            minFlag++;

        }
        public int poll(){
            if (size==0){
                throw new RuntimeException("没数了！别加了！");
            }
            size--;
            minFlag--;
            int ans = arr[pollI];
            pollI = nextIndex(pollI);
            return ans;
        }

        public int getMin(){
            return arrMin[minFlag];
        }

        private int nextIndex(int index){
            return index<limit-1?index+1:0;
        }

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        myQueue.push(10);
        myQueue.push(7);
        myQueue.push(6);
        myQueue.push(8);
        myQueue.push(1);
        System.out.println(myQueue.poll());
        System.out.println(myQueue.getMin());

        System.out.println(Arrays.toString(myQueue.arr));
        System.out.println(Arrays.toString(myQueue.arrMin));
        System.out.println(myQueue.getMin());
    }
}

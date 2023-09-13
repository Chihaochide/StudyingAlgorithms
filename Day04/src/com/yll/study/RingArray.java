package com.yll.study;

/**
 * 用数组做一个队列出来
 */
public class RingArray {
    public static class MyQueue{
        private int[] arr;
        private int pushI;
        private int pollI;
        private int size;
        private final int limit;

        public MyQueue(int limit){
            arr = new int[limit];
            pushI = 0;
            pollI = 0;
            size = 0;
            this.limit = limit;
        }

        public void  push(int value){
            if (size==limit){
                throw new RuntimeException("队列满了！不能添加");
            }
            size++;
            arr[pushI] = value;
            pushI = nextIndex(pushI);
        }
        public int poll(int value){
            if (size==0){
                throw new RuntimeException("队列空了！不能拿了");
            }
            size--;
            int ans = arr[pollI];
            pollI = nextIndex(pollI);
            return ans;
        }
        private int nextIndex(int i){
            return i<limit-1?i+1:0;
        }

    }
}

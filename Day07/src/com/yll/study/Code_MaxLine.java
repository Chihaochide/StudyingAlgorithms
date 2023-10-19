package com.yll.study;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大线段重合问题（用堆实现）
 * 给定很多线段，每个线段都有两个数【start，end】，表示线段的开始位置喝结束位置，左右都是闭区间
 * 规定：
 * 1）线段的开始和结束位置一定都是整数值
 * 2）线段重合区域的长度必须>=1
 * 返回线段最多重合区域中，包含了几条线段？
 */
public class Code_MaxLine {
    public static class Line{
        public int start;
        public int end;
        public Line(int s,int e){
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "Line{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static class MyCompare implements Comparator<Line>{
        @Override
        public int compare(Line o1, Line o2) {
            return o1.start-o2.start;
        }
    }
    public static int maxCover2(int[][] m){
       Line[] lines = new Line[m.length];
       for (int i = 0;i<m.length;i++){
           lines[i] = new Line(m[i][0],m[i][1]);
       }
        Arrays.sort(lines,new MyCompare());
        System.out.println("Arrays.toString(lines) = " + Arrays.toString(lines));
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // 小根堆，用来存放每一条线段的结尾数值
        int max = 0;
        for (int i = 0;i< lines.length;i++){
            while (!heap.isEmpty()&&heap.peek()<=lines[i].start){
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
       return max;
    }
    public static void main(String[] args) {
        int[][] m1 = new int[][]{{1,3},{1,5},{2,6},{3,8}};
        System.out.println(maxCover2(m1));
    }
}

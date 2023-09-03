package com.yll.study;

public class Demo {
    public static void main(String[] args) {
        int maxSize = 20;
        int maxValue = 7;

        for (int i = 0; i < 20; i++) {
            int a = (int)((maxValue+1)*Math.random())-(int)(maxValue*Math.random());
            System.out.println("a = " + a);

        }


    }
}

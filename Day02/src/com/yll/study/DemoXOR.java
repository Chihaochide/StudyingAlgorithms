package com.yll.study;

public class DemoXOR {
    public static void swap(int a,int b){
        /**
         * 因为异或是相同为0 不同唯一，且符合加法的交换律和结合律，则可以用来做不需要额外空间的交换操作
         * 举例：1^0 = 1; 1^1 = 0;
         * 0^任何数都是它本身
         * 1^0^1^1 = 0^1^1^1 结果是：1
         * 1^1^0^0^ = 0^1^1^0 结果是：0
         * 由此可知：偶数个个1异或 为0，基数个个1异或为1
         *
         * 进行交换：
         * a = a^b;
         * b = a^b ^b 根据相同为0，则 a^b^b 中两个b就为0-->a^0==a 所以 b=a;
         * a = a^b  因为 a = a^b,b=a,所以--> a = a^b ^a 则：a = b;
         */
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.format("a = %d\nb = %d",a,b);
    }
    public static void main(String[] args) {
        swap(1,2);

    }
}
